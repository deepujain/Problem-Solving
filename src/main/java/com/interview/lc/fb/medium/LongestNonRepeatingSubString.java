package com.interview.lc.fb.medium;

import java.util.HashSet;

/**
 * https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3008/
 * https://www.youtube.com/watch?v=3IETreEybaA
 */
public class LongestNonRepeatingSubString {
  public static void main(String[] args) {
    LongestNonRepeatingSubString a = new LongestNonRepeatingSubString();
    System.out.println(a.longest("pwwkew"));;
  }

  public int longest(String s) {
    int a_pointer = 0;
    int b_pointer = 0;
    int max = 0;
    StringBuffer longest = new StringBuffer();
    HashSet<Character> unique = new HashSet<Character>();

    while(b_pointer < s.length()) {
      if(!unique.contains(s.charAt(b_pointer))) {
        unique.add(s.charAt(b_pointer));
        b_pointer++;
        max = Math.max(max, unique.size());
        longest.append(s.charAt(b_pointer));
      } else {
        //Fuzzy as to why remove from a_pointer.
        //Keep moving the window until it is valid again.
        unique.remove(s.charAt(a_pointer));
        a_pointer++;
      }
    }
    return max;
  }
}
