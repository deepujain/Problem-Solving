package com.problem.solving.arraysandstrings.uniquestrings;

/**
 * Third approach does n comparisons and takes constant storage with bit vector.
 * 
 */
public class UniqueStringA3 {

    public static void main(String[] args) {
        UniqueStringA3 a3 = new UniqueStringA3();
        System.out.println(a3.isUnique("abcde".toCharArray()));
        System.out.println(a3.isUnique("abcdea".toCharArray()));
        System.out.println(a3.isUnique("abcade".toCharArray()));
    }

    public boolean isUnique(final char[] input) {
        boolean isUnique = true;
        int storage = 0;
        for (int i = 0; i < input.length; i++) {
            int position = input[i] - 'a';
            int value = 1 << position;
            if ((storage & value) > 0) {
                isUnique = false;
                break;
            } else {
                storage = storage | value;
            }
        }
        return isUnique;
    }
}
