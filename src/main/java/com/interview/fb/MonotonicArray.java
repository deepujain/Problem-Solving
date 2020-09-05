package com.interview.fb;

public class MonotonicArray {
  public static void main(String[] args) {
    MonotonicArray m = new MonotonicArray();
    System.out.println(m.isMonotonic(new int[]{1, 2, 2, 3}));
    System.out.println(m.isMonotonic(new int[]{6, 5, 4, 4}));
    System.out.println(m.isMonotonic(new int[]{1, 3, 2}));
    System.out.println(m.isMonotonic(new int[]{1, 2, 4, 5}));
  }

  public boolean isMonotonic(int arr[]) {
    return isIncreasing(arr) || isDecreasing(arr);
  }

  protected boolean isIncreasing(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        return false;
      }
    }
    return true;
  }

  protected boolean isDecreasing(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] < arr[i + 1]) {
        return false;
      }
    }
    return true;
  }
}
