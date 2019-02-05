package com.hhrb.leetcodecn;

import java.util.Arrays;

/**
 * User: Z J Wu Date: 2019/2/5 Time: 22:51 Package: com.hhrb.leetcodecn
 */
public class S1NumberOfTwo {

  public static void main(String[] args) {
    int[] arr = new int[]{2, 4, 11, 15}, result = new int[2];
    int target = 19;

    outer:
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] + arr[j] == target) {
          result[0] = i;
          result[1] = j;
          break outer;
        }
      }
    }
    System.out.println(Arrays.toString(result));
  }
}
