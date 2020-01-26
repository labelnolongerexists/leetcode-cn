package com.hhrb.leetcodecn.lc;

import com.hhrb.leetcodecn.tool.Stack;

/**
 * User: Z J Wu Date: 2020/1/26 Time: 18:49 Package: com.hhrb.leetcodecn.lc
 */
public class LC20 {

  private static final boolean isLeft(char c) {
    return ('(' == c) || ('[' == c) || ('{' == c);
  }

  private static final boolean isRight(char c) {
    return (')' == c) || (']' == c) || ('}' == c);
  }

  private static final boolean isValid(char left, char right) {
    return //
      ('(' == left && ')' == right) || //
        ('[' == left && ']' == right) || //
        ('{' == left && '}' == right);
  }

  public static final boolean isValidParentheses(String s) {
    char[] array = s.toCharArray();
    Stack<Character> stack = new Stack();
    for (int i = 0; i < array.length; i++) {
      char c = array[i];
      if (isLeft(c)) {
        stack.push(c);
      } else if (isRight(c)) {
        Character recentLeft = stack.getHead().val;
        if (recentLeft == null) {
          return false;
        }
        if (isValid(recentLeft, c)) {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    return stack.getHead() == null;
  }

  public static void main(String[] args) {
    System.out.println(isValidParentheses("{[]}"));
  }
}
