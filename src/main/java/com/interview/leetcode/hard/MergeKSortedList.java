package com.interview.leetcode.hard;

import java.util.PriorityQueue;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * https://www.youtube.com/watch?v=zLcNwcR6yO4
 */
public class MergeKSortedList {
  public static void main(String[] args) {
    MergeKSortedList m = new MergeKSortedList();
    //m.mergeKLists();
  }

  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    //Add each element into min heap.
    for (int i = 0; i < lists.length; i++) {
      ListNode root = lists[i];
      while (root != null) {
        minHeap.add(root.val);
        root = root.next;
      }
    }

    //Construct a linked list be removing (poll) each element from min heap.
    ListNode root = new ListNode(-1);
    ListNode pointer = root;
    while (!minHeap.isEmpty()) {
      pointer.next = new ListNode(minHeap.poll());
      pointer = pointer.next;
    }
    //root points to a blank node and hence return root.next that is the start of the sorted list.
    return root.next;
  }
}
