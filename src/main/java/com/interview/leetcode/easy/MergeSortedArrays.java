package com.interview.leetcode.easy;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArrays {
  public static void main(String[] args) {
    //nums1 has enough space for merged array. Use it.
    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    int m = 3;
    int[] nums2 = new int[]{2, 5, 6};
    int n = 3;
    MergeSortedArrays ms = new MergeSortedArrays();
    ms.merge(nums1, m, nums2, n);
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] result = new int[nums1.length];
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < m && j < n) {
      if (nums1[i] < nums2[j]) {
        result[k++] = nums1[i++];
      } else if (nums1[i] > nums2[j]) {
        result[k++] = nums2[j++];
      } else {
        result[k++] = nums1[i++];
        result[k++] = nums2[j++];
      }
    }

    while (i < m) {
      result[k++] = nums1[i++];
    }

    while (j < n) {
      result[k++] = nums2[j++];
    }

    System.arraycopy(result, 0, nums1, 0, result.length);
  }
}
