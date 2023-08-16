package com.interview.leetcode.medium;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * https://www.youtube.com/watch?v=txDnNLh91Tk
 */
public class KthLargest {
  int k;
  PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

  public KthLargest(int k, int[] nums) {
    this.k = k;
    for (int i : nums) {
      add(i);
    }
  }

  public int add(int val) {
    if (minHeap.size() < k) {
      minHeap.add(val);
    } else {
      minHeap.poll();
      minHeap.add(val);
    }
    return minHeap.peek();
  }
}

