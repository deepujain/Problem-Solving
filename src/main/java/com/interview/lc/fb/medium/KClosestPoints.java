package com.interview.lc.fb.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * https://www.youtube.com/watch?v=VORIA407dB4
 * https://www.youtube.com/watch?v=1rEUgAG7f_c
 */
public class KClosestPoints {
  public static void main(String[] args) {
    int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
    KClosestPoints k = new KClosestPoints();
    int[][] kPoints = k.kClosest(points,2);
  }

  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int []> minHeap = new PriorityQueue<int[]>(points.length,new PointCompator());

    for (int i = 0; i < points.length; i++) {
      minHeap.add(points[i]);
    }

    int[][] kpoints = new int[k][];
    int i = 0;
    while(i<k && !minHeap.isEmpty()) {
      kpoints[i] = minHeap.poll();
      i++;
    }
    return kpoints;
  }
}

class PointCompator implements Comparator<int []> {
  @Override
  public int compare(int[] p1, int[] p2) {
    double p1Distance = computeEDistanceFromOrigin(p1[0], p1[1]);
    double p2Distance = computeEDistanceFromOrigin(p2[0], p2[1]);
    if (p1Distance == p2Distance) {
      return 0;
    } else if (p1Distance < p2Distance) {
      return -1;
    } else {
      return 1;
    }
  }

  protected double computeEDistanceFromOrigin(int x1, int y1) {
    int x2 = 0, y2 = 0;
    return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
  }
}
