package com.interview.leetcode.easy;

import java.util.Random;

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class LinkedListRandom {
  ListNode head = null;

  public static void main(String[] args) {

    int i = 3;
    ListNode prev = null;
    ListNode head = null;
    while (i >= 0) {
      ListNode current = new ListNode();
      current.val = i;
      if(prev == null) {
        head = current;
      } else {
        prev.next = current;
      }
      prev = current;
      i--;
    }

    LinkedListRandom sol = new LinkedListRandom(head);
    System.out.println(sol.getRandom());
    System.out.println(sol.getRandom());
    System.out.println(sol.getRandom());
    System.out.println(sol.getRandom());
    System.out.println(sol.getRandom());
    System.out.println(sol.getRandom());
    System.out.println(sol.getRandom());
    System.out.println(sol.getRandom());
    System.out.println(sol.getRandom());
  }
  /**
   * @param head The linked list's head.
   *             Note that the head is guaranteed to be not null, so it contains at least one node.
   */
  public LinkedListRandom(ListNode head) {
    this.head = head;
  }

  /**
   * Returns a random node's value.
   */
  public int getRandom() {
    Random rand = new Random();
    int size = length(head);
    if (size == 0) {
      return -1;
    }
    int index = rand.nextInt(size);
    ListNode node = head;
    int start = 0;
    while (node.next != null) {
      if (start == index) {
        break;
      } else {
        start++;
      }
      node = node.next;
    }
    return node.val;
  }

  public int length(ListNode head) {
    ListNode node = head;
    if (node == null) {
      return 0;
    }

    int length = 1;
    while (node.next != null) {
      length++;
      node = node.next;
    }
    return length;
  }
}
