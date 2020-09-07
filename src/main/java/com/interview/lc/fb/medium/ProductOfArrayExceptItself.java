package com.interview.lc.fb.medium;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * https://www.youtube.com/watch?v=tSRFtR3pv74
 */
public class ProductOfArrayExceptItself {
  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4};

    ProductOfArrayExceptItself p = new ProductOfArrayExceptItself();
    p.productExceptSelf(nums);
  }

  public int[] productExceptSelf(int[] nums) {
    int[] left = new int[nums.length];
    int[] right = new int[nums.length];
    int[] result = new int[nums.length];

    left[0] = 1;
    for (int i = 0; i < nums.length - 1; i++) {
      left[i + 1] = nums[i] * left[i];
    }

    right[nums.length - 1] = 1;
    for (int i = nums.length - 1; i > 0; i--) {
      right[i-1] = nums[i] * right[i];
    }

    for (int i = 0; i < nums.length ; i++) {
      result[i] = left[i] * right[i];
    }
    return result;
  }
}
