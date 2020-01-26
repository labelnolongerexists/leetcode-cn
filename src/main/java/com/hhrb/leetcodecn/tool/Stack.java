package com.hhrb.leetcodecn.tool;

/**
 * User: Z J Wu Date: 2020/1/26 Time: 17:50 Package: com.hhrb.leetcodecn.tool
 */
public class Stack<T> {

  private LinkedListNode<T> head;

  public void push(LinkedListNode<T> linkedListNode) {
    linkedListNode.next = head;
    this.head = linkedListNode;
  }

  public void push(T t) {
    LinkedListNode<T> linkedListNode = new LinkedListNode<>(t);
    linkedListNode.next = head;
    this.head = linkedListNode;
  }

  public LinkedListNode<T> pop() {
    LinkedListNode head = this.head;
    if (head == null) {
      return null;
    }
    LinkedListNode next = head.next;
    this.head = next;
    return head;
  }

  public T popValue() {
    LinkedListNode<T> node = pop();
    return node == null ? null : node.val;
  }

  public LinkedListNode<T> getHead() {
    return this.head;
  }

  public T getHeadValue() {
    return this.head == null ? null : this.head.val;
  }

  public LinkedListNode<T> clear() {
    LinkedListNode head = getHead();
    this.head = null;
    return head;
  }

}
