package com.hhrb.leetcodecn.oldlc;

/**
 * User: Z J Wu Date: 2019/2/8 Time: 11:03 Package: com.hhrb.leetcodecn
 */
public class DeleteDuplicatesLinkedList {

  public static class ListNode {

    private int val;
    private ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static ListNode distinct(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode current = head, newHead = new ListNode(head.val), current2 = newHead;
    int val = current.val;
    for (; ; ) {
      if (current == null) {
        break;
      }
      if (val != current.val) {
        val = current.val;
        current2.next = new ListNode(current.val);
        current2 = current2.next;
      }
      current = current.next;
    }
    return newHead;
  }

  public static void print(ListNode ln) {
    ListNode current = ln;
    StringBuilder sb = new StringBuilder();
    for (; ; ) {
      if (current == null) {
        break;
      }
      sb.append(current.val);
      sb.append(',');
      current = current.next;
    }
    System.out.println(sb.toString());
  }

  public static void main(String[] args) {
    ListNode ln1 = new ListNode(1);
    ListNode ln2 = new ListNode(1);
    ListNode ln3 = new ListNode(2);
    ListNode ln4 = new ListNode(3);
    ListNode ln5 = new ListNode(3);

    ln1.next = ln2;
    ln2.next = ln3;
    ln3.next = ln4;
    ln4.next = ln5;

    print(ln1);
    print(distinct(ln1));
  }
}
