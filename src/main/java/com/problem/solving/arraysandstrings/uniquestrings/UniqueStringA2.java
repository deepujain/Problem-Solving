package com.problem.solving.arraysandstrings.uniquestrings;

import java.util.HashMap;
import java.util.Map;

/**
 * The second approach uses a additional storage that would eventually occupy
 * length of input and takes O(n) to determine if input string contains unique
 * characters.
 * 
 */
public class UniqueStringA2 {

    public static void main(String[] args) {
        UniqueStringA2 a2 = new UniqueStringA2();
        System.out.println(a2.isUnique("abcde".toCharArray()));
        System.out.println(a2.isUnique("abcdea".toCharArray()));
        System.out.println(a2.isUnique("abcade".toCharArray()));
    }

    public boolean isUnique(final char[] input) {
        boolean isUnique = true;
        Map<String, Boolean> storage = new HashMap<String, Boolean>();
        for (int i = 0; i < input.length; i++) {
            if (storage.containsKey(input[i] + "")) {
                isUnique = false;
                break;
            } else {
                storage.put(input[i] + "", true);
            }
        }
        return isUnique;
    }
}
