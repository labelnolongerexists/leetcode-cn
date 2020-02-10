package com.hhrb.leetcodecn.lc;

/**
 * User: Z J Wu Date: 2020/2/11 Time: 0:38 Package: com.hhrb.leetcodecn.lc
 */
public class LC11 {

  // 双指针法.
  public static int solution2(int[] h) {
    // 左右指针, 初始状态分别指向最左边的柱子和最右边的柱子
    int left = 0, right = h.length - 1;
    int maxArea = 0;
    // 左右的柱子相遇, 停止循环
    while (left < right) {
      maxArea = Math.max(maxArea, (right - left) * Math.min(h[left], h[right]));
      //总是向内侧(左柱子向右, 右柱子向左)移动矮一些的那个柱子.
      if (h[left] < h[right]) {
        ++left;
      } else {
        --right;
      }
    }

    return maxArea;
  }

  /*
   * 暴力法, 根据公式, 朴素的计算出所有可以围成正方形的面积, 取最大值
   * h = 输入的高度数组
   * f(0) = 0
   * f(1) = max(f(0), 1*min(h[0], h[1]))
   * f(n) = max(f(n-1), 1*min(h[n-1], h[n]), 2*min(h[n-2], h[n])..., n*min(h[0], h[n]))
   */
  public static int solution1(int[] h) {
    int maxArea = 0;
    for (int i = 0; i < h.length; i++) {
      for (int j = i + 1; j < h.length; j++) {
        maxArea = Math.max(maxArea, (j - i) * Math.min(h[i], h[j]));
      }
    }
    return maxArea;
  }

  /*
   * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
   * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)
   * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
   *
   * 输入: [1,8,6,2,5,4,8,3,7], 返回49

         |                 |
         |                 |  |
         |  |              |  |
         |  |     |        |  |
         |  |     |  |     |  |
         |  |     |  |  |  |  |
         |  |  |  |  |  |  |  |
      |  |  |  |  |  |  |  |  |
      -------------------------
      0  1  2  3  4  5  6  7  8
   */
  public static void main(String[] args) {
    final int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(solution1(input));
    System.out.println(solution2(input));
  }

}
