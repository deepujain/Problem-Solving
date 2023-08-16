package com.interview.leetcode.easy.dynamic;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public class HowSum {

  public static void main(String[] args) {
    HowSum c = new HowSum();
    System.out.println(Arrays.toString(c.canSum(7, new int[]{2, 4})));
    System.out.println(Arrays.toString(c.canSum(7, new int[]{2, 3})));
    System.out.println(Arrays.toString(c.canSum(7, new int[]{7, 14})));
    System.out.println(Arrays.toString(c.canSum(8, new int[]{2, 3, 5})));
  }

  int[] canSum(int targetSum, int[] numbers) {
    if (targetSum == 0) return new int[]{};
    if (targetSum < 0) return null;

    for (int num : numbers) {
      int remainder = targetSum - num;
      int[] result = canSum(remainder, numbers);
      if (result != null) {
        return ArrayUtils.add(result, num);
      }
    }
    return null;
  }
}
