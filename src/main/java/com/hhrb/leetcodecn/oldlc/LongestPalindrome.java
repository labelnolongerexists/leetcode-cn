package com.hhrb.leetcodecn.oldlc;

/**
 * User: Z J Wu Date: 2019/2/6 Time: 13:18 Package: com.hhrb.leetcodecn
 */
public class LongestPalindrome {

  public static boolean isPal(String raw, int from, int to) {
    int i = from, j = to;
    if (j - i + 1 < 2) {
      return true;
    }
    for (; ; ) {
      if (i >= j) {
        break;
      }
      if (raw.charAt(i) != raw.charAt(j)) {
        return false;
      }
      ++i;
      --j;
    }
    return true;
  }

  public static String longestPalindrome(String s) {
    if (s.length() < 2) {
      return s;
    }
    int max = 0;
    String pal = "";
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        if (isPal(s, i, j) && (j - i + 1) > max) {
          pal = s.substring(i, j + 1);
          max = j - i + 1;
        }
      }
    }
    return pal;
  }

  public static void main(String[] args) {
    String s = "abbc";
    System.out.println(longestPalindrome(s));
  }
}
