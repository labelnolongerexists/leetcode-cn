package com.hhrb.leetcodecn.tool;

import java.util.Random;
import java.util.StringJoiner;

/**
 * User: Z J Wu Date: 2020/1/25 Time: 19:14 Package: com.hhrb.leetcodecn
 */
public class ListNode {

  public static final Random RANDOM = new Random();

  public static final String list2String(ListNode node) {
    StringBuilder sb = new StringBuilder();
    ListNode current = node;
    for (; ; ) {
      sb.append(current.val);
      if (current.next == null) {
        break;
      }
      sb.append("->");
      current = current.next;
    }

    return sb.toString();
  }

  public static final ListNode randomListNodes(int count) {
    ListNode vHead = new ListNode(0), current = vHead;
    for (int i = 0; i < count; i++) {
      int value = RANDOM.nextInt(100);
      ListNode newNode = new ListNode(value);
      current.next = newNode;
      current = newNode;
    }
    return vHead.next;
  }

  public static final ListNode serialListNodes(int count) {
    ListNode vHead = new ListNode(0), current = vHead;
    for (int i = 0; i < count; i++) {
      ListNode newNode = new ListNode(i + 1);
      current.next = newNode;
      current = newNode;
    }
    return vHead.next;
  }

  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "(", ")").add(String.valueOf(val)).toString();
  }
}
