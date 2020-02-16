## LFU的实现和一些心得
### 实现原理
1. 复合的结构, 内嵌1个hash和1个双向链表, 同时2个指针指向链表的头部和尾部
2. hash的目的是o(1)的查找效率
3. 双向链表的目的是, 总是将最新访问元素, 移动到头部.

### 一些细节

1. 为何是双向链表:

   因为切断一个节点的时候, 需要将其上一个节点和其下一个节点相连.

2. 在实现上, 最好使用一个彻底的切断方法, 彻底的切断一个不需要的节点, 目的是防止出现未切断的引用, 导致某个需要被淘汰或删除的节点由于存在引用而无法被`GC`识别

   实现:

   ```java
   // 切断一切联系, 让该节点成为孤儿, 可以促进GC
   public ListNode<T> cutAll() {
     if (this.previous != null) {
       this.previous.next = null;
     }
     if (this.next != null) {
       this.next.previous = null;
     }
     this.previous = null;
     this.next = null;
     return this;
   }
   ```

3. 注意维护`hash`的存储, 尤其是在`lfu`满了后, 如果需要淘汰队尾, 记得将其从`hash`存储里移除. 否则hash会被撑爆, 这也是为什么cache节点里必须同时存储`key`和`value`, 因为淘汰尾结点的时候需要其`key`才能调用`hash`的`remove`方法移除.

  实现:

  ```java
  // 如果满了, 则淘汰尾部, 同时将刚放入的节点变成头部
  else if (isFull()) {
    // 让当前尾节点变成孤儿
    ListNode<CacheObject<K, V>> eliminated = this.tail.cutAll();
    // 别忘了在hash里面也要扔掉这个淘汰的key, 否则map会爆
    this.STORE.remove(eliminated.nodeContent.key);
    this.head = node.append(this.head);
  }
  ```
