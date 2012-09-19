package com.problem.solving.arraysandstrings.uniquestrings;

/**
 * The first approach compares each character with other and hence takes O(n2).
 */
public class UniqueStringA1 {

    public static void main(String[] args) {
        UniqueStringA1 a1 = new UniqueStringA1();
        System.out.println(a1.isUnique("abcde".toCharArray()));
        System.out.println(a1.isUnique("abcdea".toCharArray()));
        System.out.println(a1.isUnique("abcade".toCharArray()));
    }

    public boolean isUnique(final char[] input) {
        boolean isUnique = true;
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] == input[j]) {
                    isUnique = false;
                    break;
                }
            }
        }
        return isUnique;
    }
}