package com.hhrb.leetcodecn.tool;

import java.util.Random;
import java.util.StringJoiner;

/**
 * User: Z J Wu Date: 2020/1/25 Time: 19:14 Package: com.hhrb.leetcodecn
 */
public class LinkedListNode {

  public static final Random RANDOM = new Random();

  public static final String list2String(LinkedListNode node) {
    StringBuilder sb = new StringBuilder();
    LinkedListNode current = node;
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

  public static final LinkedListNode randomListNodes(int count) {
    LinkedListNode vHead = new LinkedListNode(0), current = vHead;
    for (int i = 0; i < count; i++) {
      int value = RANDOM.nextInt(100);
      LinkedListNode newNode = new LinkedListNode(value);
      current.next = newNode;
      current = newNode;
    }
    return vHead.next;
  }

  public static final LinkedListNode serialListNodes(int count) {
    LinkedListNode vHead = new LinkedListNode(0), current = vHead;
    for (int i = 0; i < count; i++) {
      LinkedListNode newNode = new LinkedListNode(i + 1);
      current.next = newNode;
      current = newNode;
    }
    return vHead.next;
  }

  public int val;
  public LinkedListNode next;

  public LinkedListNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "(", ")").add(String.valueOf(val)).toString();
  }
}
