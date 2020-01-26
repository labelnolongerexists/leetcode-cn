package com.hhrb.leetcodecn;

import com.hhrb.leetcodecn.tool.ListNode;
import com.hhrb.leetcodecn.tool.Stack;

/**
 * User: Z J Wu Date: 2020/1/25 Time: 19:04 Package: com.hhrb.leetcodecn
 */
public class LC25 {

  public static int resetCounter() {
    return 0;
  }

  // 翻轉鏈錶
  public static final ListNode reverseNode(ListNode node) {
    ListNode next, previous = null, current = node;
    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    return previous;
  }

  public static final ListNode reverseNodesInKGroup(ListNode head, final int k) {
    ListNode vHead = new ListNode(0);

    int counter = resetCounter();
    ListNode current = head, nextOfGroup, previousOfGroup = null;
    vHead.next = head;
    ListNode next, previous = null;
    Stack stack = new Stack();
    for (; ; ) {
      if (current == null) {
        break;
      }
      ++counter;
      next = current.next;

      stack.push(current);

      if (counter == 1) {
        previousOfGroup = previous;
      } else if (counter < k) {

      } else {
        nextOfGroup = next;
        ListNode headOfStack = stack.getHead();
        if (previousOfGroup == null) {
          vHead.next = headOfStack;
        } else {
          previousOfGroup.next = headOfStack;
        }
        ListNode lastOfStack;
        while (true) {
          ListNode poped = stack.pop();
          if (poped.next == null) {
            lastOfStack = poped;
            break;
          }
        }
        lastOfStack.next = nextOfGroup;
        counter = resetCounter();
        stack.clear();
        current = lastOfStack;
      }
      previous = current;
      current = next;
    }

    return vHead.next;
  }

  public static void main(String[] args) {
    ListNode head;
    head = ListNode.serialListNodes(10);
    System.out.println(ListNode.list2String(head));
    System.out.println(ListNode.list2String(reverseNode(head)));

    head = ListNode.serialListNodes(10);
    System.out.println(ListNode.list2String(reverseNodesInKGroup(head, 3)));
  }
}
