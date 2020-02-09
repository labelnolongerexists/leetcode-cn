package com.hhrb.leetcodecn.tool;

import java.util.StringJoiner;

/**
 * User: Z J Wu Date: 2020/1/26 Time: 22:47 Package: com.hhrb.leetcodecn.tool
 */
public class DoubleLinkedListNode<T> {

  public DoubleLinkedListNode<T> previous;
  public DoubleLinkedListNode<T> next;
  public T val;

  public DoubleLinkedListNode(T val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "(", ")").add(String.valueOf(val)).toString();
  }
}
