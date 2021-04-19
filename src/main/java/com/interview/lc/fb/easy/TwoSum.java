package com.interview.lc.fb.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
  public static void main(String[] args) {
    TwoSum test = new TwoSum();
    int output[] = test.twoSum(new int[]{2,3,4,5},9);
    if(output.length == 2){
      System.out.print("[");
      System.out.print(output[0]);
      System.out.print(",");
      System.out.print(output[1]);
      System.out.print("]");
    }
  }

  public int[] twoSum(int[] nums, int target) {
    //Map = (target-nums[i], index)
    Map<Integer, Integer> store = new HashMap<Integer, Integer>();
    int output[] = new int[2];
    for(int i=0;i<nums.length;i++) {
      if(store.containsKey(nums[i])) {
        output[0] = store.get(nums[i]);
        output[1] = i;
      } else {
        store.put(target-nums[i], i);
      }
    }
    return output;
  }
}
