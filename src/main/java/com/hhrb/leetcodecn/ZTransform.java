package com.hhrb.leetcodecn;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Z J Wu Date: 2019/2/6 Time: 18:39 Package: com.hhrb.leetcodecn
 */
public class ZTransform {

  public static String zTransform(String s, int column) {
    if (s == null || s.length() < column || column < 2) {
      return s;
    }
    int crackSize = column - 2, cycleSize = column + crackSize;
    List<StringBuilder> sbList = new ArrayList<>(column);
    for (int i = 0; i < column; i++) {
      sbList.add(new StringBuilder());
    }
    for (int i = 0; i < s.length(); i++) {
      int mod = i % cycleSize;
      int newColumn;
      if (mod < column) {
        newColumn = mod;
      } else {
        newColumn = 2 * column - mod - 2;
      }
      sbList.get(newColumn).append(s.charAt(i));
    }
    StringBuilder sb = new StringBuilder(s.length());
    sbList.stream().forEach(sb::append);
    return sb.toString();
  }

  public static void main(String[] args) {
    String raw = "abcdefghijklmnopqrstuvwxyz";
    int column = 4;
    System.out.println(raw);
    System.out.println(zTransform(raw, column));
  }
}
