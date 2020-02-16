package com.hhrb.leetcodecn.tool;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Map;
import java.util.StringJoiner;

/**
 * User: Z J Wu Date: 2020/2/14 Time: 1:51 Package: com.hhrb.leetcodecn.tool
 */
public class SimpleLFUCache<K, V> implements SimpleCache<K, V> {

  private static final class ListNode<T> {

    private T nodeContent;

    private ListNode<T> next;
    private ListNode<T> previous;

    public ListNode(T nodeContent) {
      this.nodeContent = nodeContent;
    }

    public ListNode<T> append(ListNode<T> nextNode) {
      // 不能有环
      Preconditions.checkArgument(nextNode != this, "Loop");
      this.next = nextNode;
      if (nextNode != null) {
        nextNode.previous = this;
      }
      return this;
    }

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
  }

  private static final class CacheObject<K, V> {

    private K key;
    private V val;

    private long updateTime;

    private int accessedCount;

    public CacheObject() {
    }

    public void update(K key, V val) {
      this.key = key;
      this.val = val;
      this.updateTime = System.currentTimeMillis();
    }

    public V getVal() {
      return val;
    }

    public long getUpdateTime() {
      return updateTime;
    }

    public CacheObject<K, V> accumulateAccessCount() {
      ++this.accessedCount;
      return this;
    }

    @Override
    public String toString() {
      return new StringJoiner("").add("val=" + val).add("@" + updateTime).add("|" + accessedCount)
                                 .toString();
    }
  }

  private final int capacity;
  private int size;

  private final Map<K, ListNode<CacheObject<K, V>>> STORE;
  private ListNode<CacheObject<K, V>> head;
  private ListNode<CacheObject<K, V>> tail;

  public SimpleLFUCache(int capacity) {
    this.capacity = capacity;
    this.STORE = Maps.newHashMapWithExpectedSize(capacity);
  }

  private void moveToHead(ListNode<CacheObject<K, V>> current) {
    Preconditions.checkArgument(current != null);
    if (this.head == current) {
      return;
    }
    final ListNode<CacheObject<K, V>> previous = current.previous, next = current.next;
    current.cutAll();
    previous.append(next);
    current.append(this.head);
    this.head = current;
  }

  @Override
  public V get(K key) {
    final ListNode<CacheObject<K, V>> current = STORE.get(key);
    if (current == null) {
      return null;
    }
    V val = current.nodeContent.accumulateAccessCount().getVal();
    // 如果当前节点不是头部, 则当前节点从当前位置切断
    // 1. 当前节点变成头部
    // 2. 当前节点的前一个节点(如果有)和当前节点的下一个节点(如果有)自然衔接到一起
    if (current != this.head) {
      moveToHead(current);
    }
    return val;
  }

  @Override
  public void put(K key, V val) {
    ListNode<CacheObject<K, V>> node = STORE.get(key);
    if (node == null) {
      node = new ListNode<>(new CacheObject<>());
      STORE.put(key, node);
      // 如果是空的, 直接头=尾=新增的节点
      if (isEmpty()) {
        this.head = this.tail = node;
        ++size;
      }
      // 如果满了, 则淘汰尾部, 同时将刚放入的节点变成头部
      else if (isFull()) {
        // 让当前尾节点变成孤儿
        ListNode<CacheObject<K, V>> eliminated = this.tail.cutAll();
        // 别忘了在hash里面也要扔掉这个淘汰的key, 否则map会爆
        this.STORE.remove(eliminated.nodeContent.key);
        this.head = node.append(this.head);
      }
      // 不空也不满, 当前节点变成头节点
      else {
        this.head = node.append(this.head);
        ++size;
      }
    } else {
      moveToHead(node);
    }
    node.nodeContent.accumulateAccessCount().update(key, val);
  }

  public final boolean isFull() {
    return this.size == capacity;
  }

  public final boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public V remove(K key) {
    ListNode<CacheObject<K, V>> existingNode = STORE.remove(key);
    if (existingNode == null) {
      return null;
    }
    final ListNode<CacheObject<K, V>> prev = existingNode.previous, next = existingNode.next;
    existingNode.cutAll();
    if (this.head == existingNode) {
      this.head = next;
    } else if (this.tail == existingNode) {
      this.tail = prev;
    } else {
      prev.append(next);
    }

    return existingNode.nodeContent.val;
  }

  @Override
  public int size() {
    return this.size;
  }

  public static void main(String[] args) {
    SimpleCache<Integer, String> cache = new SimpleLFUCache<>(3);

    cache.put(1, RandomStringUtils.randomAlphanumeric(5));
    System.out.println(cache);
    cache.get(1);
    System.out.println(cache);

    cache.put(2, RandomStringUtils.randomAlphanumeric(5));
    System.out.println(cache);
    cache.get(2);
    System.out.println(cache);

    cache.get(1);
    System.out.println(cache);
    cache.get(2);
    System.out.println(cache);

    cache.put(3, RandomStringUtils.randomAlphanumeric(5));
    System.out.println(cache);
    cache.get(2);
    System.out.println(cache);

    cache.put(3, RandomStringUtils.randomAlphanumeric(5));
    System.out.println(cache);
    cache.get(3);
    System.out.println(cache);

    cache.get(2);
    System.out.println(cache);

    cache.put(4, RandomStringUtils.randomAlphanumeric(5));
    System.out.println(cache);
    cache.get(3);
    System.out.println(cache);

    cache.remove(4);
    System.out.println(cache);

    cache.put(4, RandomStringUtils.randomAlphanumeric(5));
    System.out.println(cache);

    cache.remove(2);
    System.out.println(cache);

    cache.put(5, RandomStringUtils.randomAlphanumeric(5));
    System.out.println(cache);

    cache.remove(5);
    System.out.println(cache);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(new StringJoiner(", ", SimpleLFUCache.class.getSimpleName() + "[", "]")
                .add("capacity=" + capacity).add("size=" + size).add("storeSize=" + STORE.size())
                .toString());
    sb.append(": ");
    ListNode<CacheObject<K, V>> node = this.head;

    if (node != null) {
      sb.append("(");
      sb.append(node.nodeContent.key);
      sb.append('=');
      sb.append(node.nodeContent.val);
      sb.append("@");
      sb.append(node.nodeContent.accessedCount);
      sb.append(")");
      node = node.next;
    }
    while (node != null) {
      sb.append("->(");
      sb.append(node.nodeContent.key);
      sb.append('=');
      sb.append(node.nodeContent.val);
      sb.append("@");
      sb.append(node.nodeContent.accessedCount);
      sb.append(")");
      node = node.next;
    }
    return sb.toString();
  }
}
