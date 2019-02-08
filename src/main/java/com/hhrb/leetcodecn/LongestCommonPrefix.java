package com.hhrb.leetcodecn;

/**
 * User: Z J Wu Date: 2019/2/7 Time: 21:26 Package: com.hhrb.leetcodecn
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 输入: ["flower","flow","flight"] 输出: "fl"
 */
public class LongestCommonPrefix {

  public static String longestCommonPrefix(String... strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }
    StringBuilder sb = new StringBuilder();
    int counter = 0;

    outer:
    for (; ; ) {
      boolean hasCommon = false;
      inner:
      for (int i = 0; i < strs.length - 1; i++) {
        if (counter >= strs[i].length() || counter >= strs[i + 1].length() || strs[i]
          .charAt(counter) != strs[i + 1].charAt(counter)) {
          hasCommon = false;
          break inner;
        } else {
          hasCommon = true;
        }
      }
      if (hasCommon) {
        sb.append(strs[0].charAt(counter));
      } else {
        break outer;
      }
      ++counter;
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(longestCommonPrefix("flower", "flow", "flight"));
    System.out.println(longestCommonPrefix("", "cbc", "c", "ca"));
    System.out.println(longestCommonPrefix("a"));
  }
}
