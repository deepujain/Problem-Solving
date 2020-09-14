package com.interview.lc.fb.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestInArray {
  public static void main(String[] args) {
    int[] elements = {4, 5, 8, 2};
    KthLargestInArray k = new KthLargestInArray();
    int kLargest = k.kLargest(elements, 2);
    System.out.println(kLargest);
  }

  public int findKthLargest(int[] nums, int k) {
    return kLargest(nums, k);
  }

  protected int kLargest(int[] elements, int k) {
    //PriorityQueue are min heaps by default. Hence we need a MaxComparator
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(elements.length, new MaxComparator());

    for (int i : elements) {
      maxHeap.add(i);
    }

    int max = -1;
    while (k > 0 && !maxHeap.isEmpty()) {
      max = maxHeap.poll();
      k--;
    }
    return max;
  }

}

class MaxComparator implements Comparator<Integer> {
  @Override
  public int compare(Integer p1, Integer p2) {
    return p2 - p1;
  }
}