package com.interview.lc.fb.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

  public static void main(String[] args) {
    MajorityElement e = new MajorityElement();
    System.out.println(e.majorityElement(new int[] {3,2,3}));
    System.out.println(e.majorityElement(new int[] {2,2,1,1,1,2,2}));
  }

  public int majorityElement(int[] nums) {
    Map<Integer, Integer> frequency = new HashMap<>();
    float maxCount = nums.length / 2;
    //Array is always non-empty.
    int max = nums[0];

    //O(n)
    for (int i : nums) {
      frequency.put(i, frequency.getOrDefault(i, 0) + 1);
      if (frequency.get(i) > maxCount) {
        max = i;
      }
    }
    return max;
  }
}
