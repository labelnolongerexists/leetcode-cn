package com.hhrb.ama;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Z J Wu Date: 2019-02-14 Time: 14:42 Package: com.hhrb.ama
 */
public class CellTest {

  public static void main(String[] args) {
    int[] input = new int[]{1, 1, 1, 0, 1, 1, 1, 1};

    for (int j = 0; j < 2; j++) {
      int previous = 0;
      for (int i = 0; i < input.length; i++) {
        int next = i == input.length - 1 ? 0 : input[i + 1];
        int r = previous ^ next;
        previous = input[i];
        input[i] = r;
      }
    }
    System.out.println(Arrays.toString(input));
    List<Integer>l=new ArrayList<>(input.length);
    Arrays.stream(input).forEach(l::add);
  }
}
