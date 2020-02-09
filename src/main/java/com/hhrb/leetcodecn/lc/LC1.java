package com.hhrb.leetcodecn.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * User: Z J Wu Date: 2020/2/9 Time: 23:58 Package: com.hhrb.leetcodecn.lc
 */
public class LC1 {

  /*
  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
  你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
  示例:
  给定 nums = [2, 7, 11, 15], target = 9
  因为 nums[0] + nums[1] = 2 + 7 = 9
  所以返回 [0, 1]
  * */
  public static void main(String[] args) {
    final int k = 11;
    int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
    Set<Integer> memo = new HashSet<>();

    Integer number1 = null, number2 = null;
    for (int i = 0; i < input.length; i++) {
      // 利用hash, 一边遍历一边保存.
      // 目标数是k减去当前数, 也就是说如果当前数+目标数是k, 那么就可以返回.
      // 因为利用了hash查找为1的特性, 因此整体在o(n)即可完成查找
      Integer targetNumber = k - input[i];
      if (memo.contains(targetNumber)) {
        number1 = input[i];
        number2 = targetNumber;
      } else {
        memo.add(input[i]);
      }
    }
    System.out.println("Number1=" + number1 + ", number2=" + number2);
  }
}
