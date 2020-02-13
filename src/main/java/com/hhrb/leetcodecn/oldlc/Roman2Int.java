package com.hhrb.leetcodecn.oldlc;

/**
 * User: Z J Wu Date: 2019/2/6 Time: 22:08 Package: com.hhrb.leetcodecn
 */
public class Roman2Int {

  public static final char PLACEHOLDER = ' ';

  private static int toInt(char c) {
    switch (c) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      default:
        return 0;
    }
  }

  private static int toSpecialInt(char c1, char c2) {
    if (c1 == 'I' && c2 == 'V') {
      return 4;
    } else if (c1 == 'I' && c2 == 'X') {
      return 9;
    } else if (c1 == 'X' && c2 == 'L') {
      return 40;
    } else if (c1 == 'X' && c2 == 'C') {
      return 90;
    } else if (c1 == 'C' && c2 == 'D') {
      return 400;
    } else if (c1 == 'C' && c2 == 'M') {
      return 900;
    } else {
      return 0;
    }
  }

  public static int romanToInt(String roman) {
    if (roman == null || roman.length() < 1) {
      return 0;
    }
    int num = 0, sLen = roman.length();
    for (int i = 0; i < sLen; ) {
      int step = 1;
      char c = roman.charAt(i), cn = i < sLen - 1 ? roman.charAt(i + 1) : PLACEHOLDER;
      int specialInt = toSpecialInt(c, cn);
      if (specialInt > 0) {
        num += specialInt;
        step = 2;
      } else {
        num += toInt(c);
      }
      i += step;
    }
    return num;
  }

  public static void main(String[] args) {
    System.out.println(romanToInt("MCMXCIV".toUpperCase()));
  }
}
