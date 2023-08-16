package com.interview.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] output = test.twoSum(new int[]{2, 3, 4, 5}, 5);
        if (output.length == 2) {
            System.out.print("[");
            System.out.print(output[0]);
            System.out.print(",");
            System.out.print(output[1]);
            System.out.print("]");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> num_indices = new HashMap<Integer, Integer>();
        int[] output = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (num_indices.containsKey(complement)) {
                output[0] = num_indices.get(complement);
                output[1] = i;
                break;
            } else {
                num_indices.put(nums[i], i);
            }
        }
        return output;
    }
}
