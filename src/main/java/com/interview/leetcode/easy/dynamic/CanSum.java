package com.interview.leetcode.easy.dynamic;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

  public static void main(String[] args) {
    CanSum c = new CanSum();
    System.out.println(c.canSum(7, new int[]{2, 4}, new HashMap<Integer, Boolean>()));
    System.out.println(c.canSum(7, new int[]{2, 3}, new HashMap<Integer, Boolean>()));
    System.out.println(c.canSum(300, new int[]{7, 14}, new HashMap<Integer, Boolean>()));
  }

  boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> memo) {
    if (memo.containsKey(targetSum)) return memo.get(targetSum);
    if (targetSum == 0) return true;
    if (targetSum < 0) return false;

    for (int num : numbers) {
      int remainder = targetSum - num;
      if (canSum(remainder, numbers, memo)) {
        memo.put(targetSum, true);
        return true;
      }
    }
    memo.put(targetSum, false);
    return false;
  }
}
