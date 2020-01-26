package com.hhrb.leetcodecn.tool;

/**
 * User: Z J Wu Date: 2020/1/26 Time: 20:10 Package: com.hhrb.leetcodecn.tool
 */
public class LinkedQueue<T> {

  private LinkedListNode<T> head;
  private LinkedListNode<T> tail;

  public LinkedQueue() {
    //    this.head = this.tail = new LinkedListNode<>(null);
  }

  public void push(T t) {
    LinkedListNode<T> newNode = new LinkedListNode(t);
    if (tail == null) {
      this.head = this.tail = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }
  }

  public LinkedListNode<T> take() {
    if (this.tail == null) {
      return null;
    }
    LinkedListNode<T> h = this.head;
    this.head = h.next;
    if (this.head == null) {
      this.tail = null;
    }
    return h;
  }

}
