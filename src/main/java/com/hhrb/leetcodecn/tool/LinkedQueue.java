package com.hhrb.leetcodecn.tool;

/**
 * User: Z J Wu Date: 2020/1/26 Time: 20:10 Package: com.hhrb.leetcodecn.tool
 */
public class LinkedQueue<T> {

  public LinkedListNode<T> head;
  public LinkedListNode<T> tail;

  public LinkedQueue() {
  }

  public boolean isEmpty() {
    return head == null;
  }

  public boolean isNotEmpty() {
    return !isEmpty();
  }

  public void push(T t) {
    LinkedListNode<T> newNode = new LinkedListNode(t);
    if (this.tail == null) {
      this.head = this.tail = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }
  }

  public LinkedListNode<T> take() {
    if (this.head == null) {
      return null;
    }
    LinkedListNode<T> h = this.head;
    this.head = h.next;
    if (this.head == null) {
      this.tail = null;
    }
    return h;
  }

  public T takeValue() {
    LinkedListNode<T> node = take();
    return node == null ? null : node.val;
  }

  public T headValue() {
    return this.head == null ? null : this.head.val;
  }

  public T tailValue() {
    return this.tail == null ? null : this.tail.val;
  }

  public static void main(String[] args) {
    LinkedQueue<Integer> queue=new LinkedQueue<>();
    queue.push(1);
    queue.push(2);
    queue.push(3);
    queue.push(4);
    while (queue.isNotEmpty()){
      System.out.println(queue.takeValue());
    }
  }

}
