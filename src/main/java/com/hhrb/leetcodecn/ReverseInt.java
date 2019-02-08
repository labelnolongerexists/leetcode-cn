package com.hhrb.leetcodecn;

/**
 * User: Z J Wu Date: 2019/2/6 Time: 21:04 Package: com.hhrb.leetcodecn
 */
public class ReverseInt {

  public static int reverse(int i) {
    boolean neg = i < 0;
    int j = 0;
    for (; ; ) {
      int p = (int) Math.pow(10, j);
      if (i / p == 0) {
        break;
      }
      ++j;
    }
    int newInt = 0, wei = 0;
    for (int k = 1; k <= j; k++) {
    }
    return 1;
  }

  public static int reverse2(int i) {
    long raw = i;
    boolean neg = i < 0;
    String s = neg ? String.valueOf(-raw) : String.valueOf(raw);
    int wei = s.length();
    long l = 0;
    for (int j = 0; j < wei; j++) {
      char c = s.charAt(wei - j - 1);
      l += (Integer.parseInt(c + "") * Math.pow(10, wei - j - 1));
    }
    if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
      return 0;
    }
    return (int) (neg ? -l : l);
  }

  public static void main(String[] args) {
    int i = -2147483648;
    System.out.println(reverse2(i));
  }
}
