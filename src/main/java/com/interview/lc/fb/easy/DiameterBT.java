package com.interview.lc.fb.easy;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * https://www.youtube.com/watch?v=ey7DYc9OANo
 */

public class DiameterBT {

  public static void main(String[] args) {
    DiameterBT dbt = new DiameterBT();

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    System.out.println(dbt.height(root));
    System.out.println(dbt.diameter(root));
  }

  public int diameterOfBinaryTreeNode(TreeNode root) {
    return diameter(root);
  }

  public int diameter(TreeNode root) {
    if (root == null) {
      return 0;
    }
    //Case1: The diameter passes through the root.
    //Diameter = height(left) + height(right)
    int heightL = height(root.left);
    int heightR = height(root.right);
    int diameterPassesThroughRoot = heightL + heightR;

    //Case2: The diameter does not passes through the root.
    //1. Computer diameter of left subtree
    //2. Computer diameter of right subtree
    //3. Max of both
    int lDiameter = diameter(root.left);
    int rDiameter = diameter(root.right);
    int diameterDoesNotPassThroughRoot = Math.max(lDiameter, rDiameter);

    //Choose the max between case1 and case2
    return Math.max(diameterPassesThroughRoot, diameterDoesNotPassThroughRoot);
  }

  public int height(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftH = height(node.left);
    int rightH = height(node.right);
    return 1 + Math.max(leftH, rightH);
  }
}
