package com.interview.lc.fb.easy;

public class BalancedBinaryTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    BalancedBinaryTree bt = new BalancedBinaryTree();
    System.out.println(bt.height(root));
    System.out.println(bt.isBalanced(root));
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    int leftTreeHeight = height(root.left);
    int rightTreeHeight = height(root.right);
    //difference of 1 is ok, but not more than 1
    if (Math.abs(leftTreeHeight - rightTreeHeight) > 1) {
      return false;
    } else {
      return isBalanced(root.left) && isBalanced(root.right);
    }
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
