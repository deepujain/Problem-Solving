package com.interview.lc.fb.easy;

import java.util.List;
import java.util.Random;

class NestedInteger {
  private int integer;
  private List<NestedInteger> list;

  public NestedInteger(int integer, List<NestedInteger> list) {
    this.integer = integer;
    this.list = list;
  }

  public boolean isInteger() {
    Random random = new Random();
    return random.nextBoolean();
  }

  public int getInteger() {
    return integer;
  }

  public void setInteger(int integer) {
    this.integer = integer;
  }

  public List<NestedInteger> getList() {
    return list;
  }

  public void setList(List<NestedInteger> list) {
    this.list = list;
  }
}

/**
 * https://leetcode.com/problems/nested-list-weight-sum/
 */
public class NestedWeightedSum {

  public static void main(String[] args) {

  }

  public int depthSum(List<NestedInteger> nestedList) {
    return depthS(nestedList, 1);
  }

  protected int depthS(List<NestedInteger> nestedList, int depth) {
    int sum = 0;
    for (NestedInteger ni : nestedList) {
      if (ni.isInteger()) {
        sum += ni.getInteger() * depth;
      } else {
        //DFS uses stack and recursive calls use method stack
        //BFS uses queue
        sum += depthS(ni.getList(), depth + 1);
      }
    }
    return sum;
  }


}
