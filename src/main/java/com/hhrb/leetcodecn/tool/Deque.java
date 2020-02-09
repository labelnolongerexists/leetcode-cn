package com.hhrb.leetcodecn.tool;

/**
 * User: Z J Wu Date: 2020/1/26 Time: 22:50 Package: com.hhrb.leetcodecn.tool
 */
public class Deque<T> {

  private DoubleLinkedListNode<T> head;
  private DoubleLinkedListNode<T> tail;

  public Deque() {
  }

  public void appendHead(T val) {
    DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>(val);
    DoubleLinkedListNode<T> h = this.head;
    if (h == null) {
      tail = head = node;
      return;
    }
    node.next = h;
    h.previous = node;
    this.head = node;
  }

  public void appendTail(T val) {
    DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>(val);
    DoubleLinkedListNode<T> t = this.tail;
    if (t == null) {
      tail = head = node;
      return;
    }
    t.next = node;
    node.previous = t;
    this.tail = node;
  }

  public DoubleLinkedListNode<T> takeFromHead() {
    DoubleLinkedListNode<T> h = this.head;
    if (h == null) {
      return null;
    }
    DoubleLinkedListNode<T> next = h.next;
    if (next == null) {
      tail = head = null;
    } else {
      this.head = next;
      h.next = null;
    }
    return h;
  }

  public DoubleLinkedListNode<T> takeFromTail() {
    DoubleLinkedListNode<T> t = this.tail;
    if (t == null) {
      return null;
    }
    DoubleLinkedListNode<T> previous = t.previous;
    if (previous == null) {
      tail = head = null;
    } else {
      this.tail = previous;
      t.previous = null;
    }
    return t;
  }

  public T takeValueFromHead() {
    DoubleLinkedListNode<T> t = takeFromHead();
    return t == null ? null : t.val;
  }

  public T takeValueFromTail() {
    DoubleLinkedListNode<T> t = takeFromTail();
    return t == null ? null : t.val;
  }

}
