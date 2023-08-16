package com.interview.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
  public TreeNode left;
  public TreeNode right;
  public int val;

  public TreeNode(int val) {
    this.val = val;
  }
}

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumBST {
  public static void main(String[] a) {

  }

  public int rangeSumBST(TreeNode root, int L, int R) {
     int sum = 0;
     if(root == null) {
       return sum;
     }

     //Use Q for BFS.
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    while(queue.isEmpty()) {
      TreeNode currentNode = queue.remove();
      if(currentNode.val >= L && currentNode.val <= R) {
        sum += currentNode.val;
      }

      //1: Traverse left of BST ?
      //2: Use BST property left tree of root is less ?
      if(currentNode.left != null && currentNode.val >= L) {
        queue.add(currentNode.left);
      }

      //1. Traverse right of BST ?
      //2: Use BST property right tree of root is less ?
      if(currentNode.right != null && currentNode.val <= R) {
        queue.add(currentNode.right);
      }
    }
    return sum;
  }
}
