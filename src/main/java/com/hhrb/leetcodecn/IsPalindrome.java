package com.hhrb.leetcodecn;

/**
 * User: Z J Wu Date: 2019/2/6 Time: 21:47 Package: com.hhrb.leetcodecn
 */
public class IsPalindrome {

  public static boolean isPalindrome(int i) {
    if (i < 0) {
      return false;
    }
    if (i < 10) {
      return true;
    }
    String s = String.valueOf(i);
    int from = 0, to = s.length() - 1;
    for (; ; ) {
      if (from >= to) {
        break;
      }
      if (s.charAt(from) != s.charAt(to)) {
        return false;
      }
      ++from;
      --to;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome(88));
  }
}
