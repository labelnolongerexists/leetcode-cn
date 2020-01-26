package com.hhrb.leetcodecn.lc;

import com.hhrb.leetcodecn.tool.Stack;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * User: Z J Wu Date: 2020/1/26 Time: 21:28 Package: com.hhrb.leetcodecn.lc
 */
public class LC739 {

  private static class Temperature {

    public final int index;
    public final int temperature;

    public Temperature(int index, int temperature) {
      this.index = index;
      this.temperature = temperature;
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", "[", "]").add(String.valueOf(index))
                                             .add(String.valueOf(temperature)).toString();
    }
  }

  private static int[] dailyTemperatures(int[] temperatures) {
    Stack<Temperature> temperatureRecords = new Stack<>();
    int[] result = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      Temperature current = new Temperature(i, temperatures[i]);
      Temperature record;
      while (true) {
        record = temperatureRecords.getHeadValue();
        if (record == null) {
          temperatureRecords.push(current);
          break;
        }
        if (current.temperature <= record.temperature) {
          temperatureRecords.push(current);
          break;
        }
        int step = current.index - record.index;
        result[record.index] = step;
        temperatureRecords.pop();
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
    System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
  }
}
