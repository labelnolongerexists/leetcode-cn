package com.hhrb.leetcodecn.sort;

import java.util.Arrays;

/**
 * User: Z J Wu Date: 2019/2/10 Time: 22:22 Package: com.hhrb.leetcodecn.sort
 */
public class QuickSort {

  public static void swap(int[] src, int i, int j) {
    int tmp = src[j];
    src[j] = src[i];
    src[i] = tmp;
  }

  // 两侧都是闭区间
  public static void quickSort(int[] src, int head, int tail) {
    if (src == null || head >= tail || tail >= src.length || src.length <= 1) {
      return;
    }

    int i = head, j = tail;
    final int pIdx = (head + tail) / 2, p = src[pIdx];

    while (i <= j) {
      while (src[i] < p) {
        ++i;
      }
      while (src[j] > p) {
        --j;
      }
      if (i < j) {
        swap(src, i, j);
        ++i;
        --j;
      } else if (i == j) {
        ++i;
      }
    }
    // 此时此刻i已经比j大了, 因此p1是从from到j
    // 而p2是从i到to
    quickSort(src, head, j);
    quickSort(src, i, tail);
  }

  public static void main(String[] args) {
    int[] src = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
    src = new int[]{3, 2, 1, 5, 4};
    System.out.println(Arrays.toString(src));
    quickSort(src, 0, src.length - 1);
    System.out.println(Arrays.toString(src));
  }
}
