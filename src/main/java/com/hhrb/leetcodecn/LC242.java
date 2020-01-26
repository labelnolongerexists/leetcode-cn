package com.hhrb.leetcodecn;

import java.util.Arrays;

/**
 * User: Z J Wu Date: 2020/1/25 Time: 18:36 Package: com.hhrb.leetcodecn
 * <p>
 * 有效的字母异位词
 */
public class LC242 {

  public static int[] toDictArray(String s) {
    char[] chars = s.toCharArray();
    int[] dict = new int[26];
    for (int i = 0; i < chars.length; i++) {
      int positionInDict = chars[i] - 97;
      ++dict[positionInDict];
    }
    return dict;
  }

  public static boolean isValidAnagram(String s, String t) {
    int[] dictS = toDictArray(s), dictT = toDictArray(t);
    Arrays.equals(dictS, dictT);
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isValidAnagram("wuzijing", "ziwujing"));
  }
}
