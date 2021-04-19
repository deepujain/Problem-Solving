package com.interview.lc.fb.hard;

import java.util.PriorityQueue;

public class MedianFinder {

  public static void main(String[] args) {
    System.out.println(-1<-2);
    System.out.println(1<2);
    MedianFinder a = new MedianFinder();

    a = new MedianFinder();
    a.addNum(-1);
    System.out.println(a.findMedian());
    a.addNum(2);
    System.out.println(a.findMedian());
    a.addNum(3);
    System.out.println(a.findMedian());
    a.addNum(4);
    System.out.println(a.findMedian());
    a.addNum(5);
    System.out.println(a.findMedian());


    a = new MedianFinder();
    a.addNum(0);
    a.addNum(0);
    System.out.println(a.findMedian());

    a = new MedianFinder();
    System.out.println(a.findMedian());
    a.addNum(1);
    System.out.println(a.findMedian());
    a.addNum(2);
    System.out.println(a.findMedian());
    a.addNum(3);
    System.out.println(a.findMedian());

  }
  PriorityQueue<Integer> rightMinHeap;
  PriorityQueue<Integer> leftMaxHeap;

  /**
   * initialize your data structure here.
   */
  public MedianFinder() {
    rightMinHeap = new PriorityQueue<>();
    leftMaxHeap = new PriorityQueue<>((a, b) -> (b - a));
  }

  /**
   * 1 2 3(Median) 4 5
   * <p>
   * All numbers LEFT side of median are less than median
   * All numbers RIGHT side of median are less than median
   *
   * @param num
   */
  public void addNum(int num) {
    //Add the first incoming number into min heap and return.
    if (leftMaxHeap.size() == 0) {
      leftMaxHeap.add(num);
      return;
    }

    if (num > leftMaxHeap.peek()) {
      //The incoming number needs to go into min heap as it falls on RIGHT side of median
      rightMinHeap.add(num);
    } else {
      //The incoming number needs to go into max heap as it falls on LEFT side of median
      leftMaxHeap.add(num);
    }
  }

  public double findMedian() {
    if (rightMinHeap.size() == 0 && leftMaxHeap.size() == 0) {
      return 0;
    }

    //Pick the peek from the biggest bucket
    if (leftMaxHeap.size() > rightMinHeap.size()) {
      return leftMaxHeap.peek();
    } else if (leftMaxHeap.size() < rightMinHeap.size()) {
      return rightMinHeap.peek();
    } else {
      int right = rightMinHeap.peek();
      int left = leftMaxHeap.peek();
      return (left + right) / 2.0;
    }
  }
}
