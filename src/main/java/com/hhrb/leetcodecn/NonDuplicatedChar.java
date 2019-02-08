package com.hhrb.leetcodecn;

import java.util.HashSet;
import java.util.Set;

/**
 * User: Z J Wu Date: 2019/2/6 Time: 10:35 Package: com.hhrb.leetcodecn
 */
public class NonDuplicatedChar {

  // pwwkek   3
  // pwwkew   3
  // abcabcbb 3
  // bbbbb    1
  // au       1
  // ""       0
  public static int m2(String s) {
    int nonDuplicate = 0;
    return nonDuplicate;
  }

  public static int m1(String s) {
    int nonDuplicate = 0;
    Set<Character> charSet = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      charSet.add(s.charAt(i));
      for (int j = i + 1; j <s.length(); j++) {
        if (charSet.contains(s.charAt(j))) {
          break;
        }
        charSet.add(s.charAt(j));
      }
      if (charSet.size() > nonDuplicate) {
        nonDuplicate = charSet.size();
      }
      charSet.clear();
    }
    return nonDuplicate;
  }

  public static void main(String[] args) {
    String s = "pwwkew";
    System.out.println(m2(s));
  }
}
