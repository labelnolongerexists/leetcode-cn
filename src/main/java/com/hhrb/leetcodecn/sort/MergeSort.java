package com.hhrb.leetcodecn.sort;

import java.util.Arrays;

/**
 * User: Z J Wu Date: 2019/2/8 Time: 20:45 Package: com.hhrb.leetcodecn.sort
 */
public class MergeSort {

  public static void merge(int[] a, int from, int mid, int to) {
    int[] tmpA = new int[mid - from], tmpB = new int[to - mid];
    System.arraycopy(a, from, tmpA, 0, mid - from);
    System.arraycopy(a, mid, tmpB, 0, to - mid);

    int f = 0, t = 0, c = from;
    for (; ; ) {
      if (f >= mid - from || t >= to - mid) {
        break;
      }
      if (tmpA[f] < tmpB[t]) {
        a[c] = tmpA[f];
        ++f;
      } else {
        a[c] = tmpB[t];
        ++t;
      }
      ++c;
    }
    for (int i = f; i < tmpA.length; i++) {
      a[c] = tmpA[i];
      ++c;
    }
    for (int i = t; i < tmpB.length; i++) {
      a[c] = tmpB[i];
      ++c;
    }
  }

  // to是开区间
  public static void sortPart(int[] a, int from, int to) {
    if ((to - from) <= 1) {
      return;
    } else if (to - from == 2) {
      if (a[from] > a[to - 1]) {
        int tmp = a[from];
        a[from] = a[to - 1];
        a[to - 1] = tmp;
      }
      return;
    }
    int mid = from + ((to - from) >> 1);
    sortPart(a, from, mid);
    sortPart(a, mid, to);
    merge(a, from, mid, to);
  }

  public static void mergeSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    sortPart(arr, 0, arr.length);
  }

  public static void main(String[] args) {
    int[] array = new int[]{26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
    System.out.println(Arrays.toString(array));
    mergeSort(array);
    System.out.println(Arrays.toString(array));
  }
}
