package com.interview.leetcode.medium;

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

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            //Reset total to carry
            int total = carry;
            if (l1 != null) {
                total = total + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total = total + l2.val;
                l2 = l2.next;
            }

            // Split the total into its carry and remainder
            carry = total / 10;
            int remainder = total % 10;
            current.next = new ListNode(remainder);
            current = current.next;
        }
        //As result is pointing to dummy
        return result.next;
    }

    public ListNode createLinkedList(int[] nums) {
        ListNode head = new ListNode();
        ListNode current = head;
        for (int num : nums) {
            current.next = new ListNode();
            current.val = num;
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        //Input numbers in reverse order
        int[] arr1 = {9, 8, 9};
        int[] arr2 = {9, 8, 9};

        AddTwoNumbers add = new AddTwoNumbers();
        ListNode l1 = add.createLinkedList(arr1);
        ListNode l2 = add.createLinkedList(arr2);

        ListNode result = add.addTwoNumbers(l1, l2);
        // Print the result linked list values
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }
}

