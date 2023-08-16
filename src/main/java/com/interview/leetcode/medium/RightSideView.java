package com.interview.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/solution/
 * https://www.youtube.com/watch?v=jCqIr_tBLKs
 */
public class RightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if(root == null) {
      return result;
    }

    //Use Q for BFS.
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    while (!queue.isEmpty()) {
      //Get all the elements at current level.
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode currentNode = queue.remove();
        //is this the last node at the level (right side) ?
        //is this the first node at the level (left side) ? change to i == 0
        if (i == size - 1) {
          result.add(currentNode.val);
        }

        if (currentNode.left != null) {
          queue.add(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.add(currentNode.right);
        }
      }
    }
    return result;
  }
}

class TreeNode {
  public TreeNode left;
  public TreeNode right;
  public int val;

  public TreeNode(int val) {
    this.val = val;
  }
}