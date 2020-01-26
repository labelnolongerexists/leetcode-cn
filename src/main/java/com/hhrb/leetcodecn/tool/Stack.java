package com.hhrb.leetcodecn.tool;

/**
 * User: Z J Wu Date: 2020/1/26 Time: 17:50 Package: com.hhrb.leetcodecn.tool
 */
public class Stack {

  private LinkedListNode head;

  public void push(LinkedListNode linkedListNode) {
    linkedListNode.next = head;
    this.head = linkedListNode;
  }

  public LinkedListNode pop() {
    LinkedListNode head = this.head;
    if (head == null) {
      return null;
    }
    LinkedListNode next = head.next;
    this.head = next;
    return head;
  }

  public LinkedListNode getHead() {
    return this.head;
  }

  public LinkedListNode clear() {
    LinkedListNode head = getHead();
    this.head = null;
    return head;
  }

}
