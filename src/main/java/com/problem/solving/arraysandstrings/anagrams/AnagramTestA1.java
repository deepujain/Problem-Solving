package com.problem.solving.arraysandstrings.anagrams;

import java.util.Arrays;

/**
 * First approach to determine if two strings are anagrams. If their lengths are
 * unequal they are not, otherwise sort both strings and then compare every
 * character in first string with second string, if an unequal character is
 * found return false immediately.
 * 
 */
public class AnagramTestA1 {

    public static void main(String[] args) {
        System.out.println(testAnagram("abcd".toCharArray(), "abcd".toCharArray()));
        System.out.println(testAnagram("abcd".toCharArray(), "abcde".toCharArray()));
        System.out.println(testAnagram("abcd".toCharArray(), "badc".toCharArray()));
        System.out.println(testAnagram("abcd".toCharArray(), "bade".toCharArray()));
    }

    static boolean testAnagram(char[] s1, char[] s2) {
        boolean areAnagrams = true;
        if (s1.length != s2.length) {
            areAnagrams = false;
        } else {
            Arrays.sort(s1);
            Arrays.sort(s2);
            for (int i = 0; i < s1.length; i++) {
                if (s1[i] != s2[i]) {
                    areAnagrams = false;
                    break;
                }
            }
        }
        return areAnagrams;
    }

}
