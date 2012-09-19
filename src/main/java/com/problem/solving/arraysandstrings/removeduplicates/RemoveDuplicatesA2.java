package com.problem.solving.arraysandstrings.removeduplicates;

/**
 * This approach uses a constant storage of size 255 (because a-zA-Z fit into
 * this space)to keep track of unique characters. tail points to end of the
 * "non-duplicate" string so far.If a unique character is found, its added to
 * end of the tail, storage is updated and tail is incremented.Otherwise next
 * character is considered.
 * 
 */
public class RemoveDuplicatesA2 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcadea".toCharArray()));
        System.out.println(removeDuplicates("abcde".toCharArray()));
        System.out.println(removeDuplicates("aaabbba".toCharArray()));
    }

    static char[] removeDuplicates(char[] input) {
        boolean[] storage = new boolean[255];
        for (int i = 0; i < storage.length; i++) {
            storage[i] = false;
        }
        storage[input[0]] = true;
        int tail = 1;
        for (int i = 1; i < input.length; i++) {
            if (!storage[input[i]]) {
                input[tail] = input[i];
                tail++;
                storage[input[i]] = true;
            }
        }

        for (int i = tail; i < input.length; i++) {
            input[i] = 0;
        }

        return input;
    }
}
