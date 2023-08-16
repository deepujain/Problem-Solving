package com.interview.leetcode.medium;

public class RandomPickWithWeight {
  public static void main(String[] args) {

  }
}

class Solution {
  int totalSum;
  int[] backet;
  public Solution(int[] w) {
    this.totalSum = getSum(w);
    this.backet = new int[w.length];
    int len = 0;
    for (int i = 0; i< w.length; i ++) {
      len += w[i];
      backet[i] = len;
      System.out.println(backet[i]);
    }
  }

  public int pickIndex() {
    double picker = this.totalSum * Math.random();
    return getIndex(picker);
  }

  private int getSum(int[] w) {
    int sum = 0;
    for (int n: w) {
      sum += n;
    }
    return sum;
  }

  private int getIndex(double target) {
    int left = 0;
    int right = this.backet.length;
    while(left < right) {
      int mid = left + (right - left) / 2;
      if (this.backet[mid] == target) {
        return mid;
      }
      if (this.backet[mid] > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
