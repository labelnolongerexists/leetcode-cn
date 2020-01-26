package com.hhrb.leetcodecn.tool;

/**
 * User: Z J Wu Date: 2020/1/26 Time: 17:50 Package: com.hhrb.leetcodecn.tool
 */
public class Stack {

  private ListNode head;

  public void push(int val) {
    ListNode listNode = new ListNode(val);
    listNode.next = head;
    this.head = listNode;
  }

  public void push(ListNode listNode) {
    listNode.next = head;
    this.head = listNode;
  }

  public ListNode pop() {
    ListNode head = this.head;
    if (head == null) {
      return null;
    }
    ListNode next = head.next;
    this.head = next;
    return head;
  }

  public ListNode getHead() {
    return this.head;
  }

  public ListNode clear() {
    ListNode head = getHead();
    this.head = null;
    return head;
  }

}
