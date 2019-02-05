package com.hhrb.leetcodecn;

/**
 * User: Z J Wu Date: 2019/2/5 Time: 22:51 Package: com.hhrb.leetcodecn
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 */
public class S1NumberOfTwo2 {

  public static class ListNode {

    private int val;

    public ListNode(int val) {
      this.val = val;
    }

    private ListNode next;
  }

  public static ListNode compute(ListNode ln1, ListNode ln2) {
    ListNode head = null, last = null, x = ln1, y = ln2;
    boolean step = false;
    for (; ; ) {
      if (x == null && y == null) {
        break;
      }
      int v1 = x == null ? 0 : x.val, v2 = y == null ? 0 : y.val;
      int totalVal = (v1 + v2) + (step ? 1 : 0);
      int mod = totalVal % 10;
      step = mod < totalVal;
      ListNode ln = new ListNode(mod);
      if (head == null) {
        head = ln;
      } else {
        last.next = ln;
      }
      last = ln;
      x = x == null ? null : x.next;
      y = y == null ? null : y.next;
    }
    if (step) {
      last.next = new ListNode(1);
    }
    return head;
  }

  public static void print(ListNode ln) {
    int total = 0, count = 0;
    ListNode a = ln;
    for (; ; ) {
      if (a == null) {
        break;
      }
      total += a.val * (Math.pow(10, count));
      ++count;
      a = a.next;
    }
    System.out.println(total);
  }

  public static void main(String[] args) {
    ListNode n11 = new ListNode(2), n12 = new ListNode(4), n13 = new ListNode(3);
    n11.next = n12;
    n12.next = n13;

    ListNode n21 = new ListNode(5), n22 = new ListNode(6), n23 = new ListNode(4);
    n21.next = n22;
    n22.next = n23;
    print(n11);
    print(n21);
    System.out.println("---------------------------------");
    print(compute(n11, n21));
  }
}
