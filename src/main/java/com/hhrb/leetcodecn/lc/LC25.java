package com.hhrb.leetcodecn.lc;

import com.hhrb.leetcodecn.tool.LinkedListNode;
import com.hhrb.leetcodecn.tool.Stack;

/**
 * User: Z J Wu Date: 2020/1/25 Time: 19:04 Package: com.hhrb.leetcodecn
 */
public class LC25 {

  public static int resetCounter() {
    return 0;
  }

  // 翻轉鏈錶
  public static final LinkedListNode reverseNode(LinkedListNode node) {
    LinkedListNode next, previous = null, current = node;
    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    return previous;
  }

  public static final LinkedListNode reverseNodesInKGroup(LinkedListNode head, final int k) {
    LinkedListNode vHead = new LinkedListNode(0);

    int counter = resetCounter();
    LinkedListNode current = head, nextOfGroup, previousOfGroup = null;
    vHead.next = head;
    LinkedListNode next, previous = null;
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
      } else if (counter == k) {
        nextOfGroup = next;
        LinkedListNode headOfStack = stack.getHead();
        if (previousOfGroup == null) {
          vHead.next = headOfStack;
        } else {
          previousOfGroup.next = headOfStack;
        }
        LinkedListNode lastOfStack;
        while (true) {
          LinkedListNode poped = stack.pop();
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
    LinkedListNode head;
    head = LinkedListNode.serialListNodes(10);
    System.out.println(LinkedListNode.list2String(head));
    System.out.println(LinkedListNode.list2String(reverseNode(head)));

    head = LinkedListNode.serialListNodes(10);
    System.out.println(LinkedListNode.list2String(reverseNodesInKGroup(head, 3)));
  }
}
