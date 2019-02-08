package com.hhrb.leetcodecn;

import java.util.Stack;

/**
 * User: Z J Wu Date: 2019/2/8 Time: 13:13 Package: com.hhrb.leetcodecn
 */
public class IsValidBrackets {

  public static final char L1 = '(';
  public static final char R1 = ')';
  public static final char L2 = '[';
  public static final char R2 = ']';
  public static final char L3 = '{';
  public static final char R3 = '}';

  public static final boolean isLeft(char c) {
    return L1 == c || L2 == c || L3 == c;
  }

  public static final boolean isMatch(char c1, char c2) {
    return (c1 == L1 && c2 == R1) || (c1 == L2 && c2 == R2) || (c1 == L3 && c2 == R3);
  }

  public static final boolean isValid(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    if (s.length() == 1) {
      return false;
    }
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (isLeft(c)) {
        stack.push(c);
        continue;
      }
      if (stack.isEmpty()) {
        return false;
      }
      char pre = stack.pop();
      if (isMatch(pre, c)) {
        continue;
      }
      return false;
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(isValid("){"));
  }

}
