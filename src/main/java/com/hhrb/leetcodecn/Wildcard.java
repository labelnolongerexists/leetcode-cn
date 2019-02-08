package com.hhrb.leetcodecn;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Z J Wu Date: 2019/2/6 Time: 22:43 Package: com.hhrb.leetcodecn
 */
public class Wildcard {

  public static class TestCase {

    private String pattern;
    private String str;

    public TestCase(String str, String pattern) {
      this.str = str;
      this.pattern = pattern;
    }
  }

  public static final char ANYTHING_N = '*';
  public static final char ANYTHING_1 = '?';

  public static boolean match(String p, String s) {
    System.out.println("P - " + p);
    System.out.println("S - " + s);
    System.out.println("---------------------------------");
    int sIdx = 0, pIdx = 0, pLen = p.length();
    // 记录*的位置
    int starIdx = -1;
    // 记录*匹配的s的位置
    int starMatchIdx = -1;

    int counter=0;
    while (sIdx < s.length()) {

      System.out.println("Round - "+counter);
      System.out.println("PatternCharIdx - " + pIdx);
      System.out.println("StringCharIdx - " + sIdx);
      System.out.println("StarIdx - " + starIdx);
      System.out.println("StarMatchStrIdx - " + starMatchIdx);
      System.out.println("---------------------------------");

      // 1. 最简单的情况, p和s完全相等, 或者p是?, 匹配任意1个s
      if (pIdx < pLen && (p.charAt(pIdx) == s.charAt(sIdx) || p.charAt(pIdx) == ANYTHING_1)) {
        System.out.println(1);
        ++sIdx;
        ++pIdx;
      }
      /*
       * 2. 匹配1次*的情况
       * 注意事项:
       * 1. 在这里不能简单的让sIdx累计. 因为*可以匹配空串的情况
       * 如果进位, 会导致类似a*b匹配ab这样的问题失败. 因为b被匹配了*, 而不是空串匹配*
       * 类似的例子还有*b匹配aab
       *
       * 这里的操作方式是, 一旦遇到*, 则p的计数累加, 但是累加之前, 记录
       * *出现的位置, 以及当时s的位置
       * */
      else if (pIdx < pLen && p.charAt(pIdx) == ANYTHING_N) {
        System.out.println(2);
        // 遇到*了, 单独记录一下*的位置
        starIdx = pIdx;
        // 同时, 记录一下这个*开始匹配的s的位置
        starMatchIdx = sIdx;
        ++pIdx;
      }
      /*
       *
       * */
      else if (starIdx != -1) {
        System.out.println(3);
        pIdx = starIdx + 1;
        ++starMatchIdx;
        sIdx = starMatchIdx;
      } else {
        return false;
      }
      ++counter;
    }
    while (pIdx < pLen && p.charAt(pIdx) == ANYTHING_N) {
      ++pIdx;
    }
    // p恰巧消耗完, 不多不少, 说明匹配成功
    return pIdx == pLen;
  }

  public static void main(String[] args) {
    List<TestCase> testCases = new ArrayList<>();
    //    testCases.add(new TestCase("aa", "a"));
    //    testCases.add(new TestCase("aa", "*"));
    //    testCases.add(new TestCase("cb", "*a"));
    //    testCases.add(new TestCase("adceb", "*a*b"));
    //    testCases.add(new TestCase("acdcb", "a*c?b"));
    testCases.add(new TestCase("cdgiaacdfiad", "cd?i*d"));
    //    testCases.add(new TestCase("abefcdgiescdfimde", "ab*cd?i*de"));
    testCases.stream().forEach(tc -> System.out.println(match(tc.pattern, tc.str)));
  }
}