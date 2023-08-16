package com.interview.leetcode.easy;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindrome {
  public static void main(String[] args) {
    ValidPalindrome v = new ValidPalindrome();
    System.out.println(v.validPalindrome("abx"));
  }

  public boolean validPalindrome(String s) {
    return isPalindromeMinusOne(s);
  }

  protected boolean isPalindrome(String s, int low, int high) {
    while (low < high) {
      if (s.charAt(low) != s.charAt(high)) {
        return false;
      }
      low++;
      high--;
    }
    return true;
  }

  protected boolean isPalindromeMinusOne(String s) {
    int low = 0;
    int high = s.length() - 1;
    while (low < high) {
      //keep marching
      if (s.charAt(low) == s.charAt(high)) {
        low++;
        high--;
      } else {
        //Remove low and is the rest of the string a palindrome ?
        if (isPalindrome(s, low + 1, high)) {
          return true;
        }
        //Remove high and is the rest of the string a palindrome ?
        if (isPalindrome(s, low, high - 1)) {
          return true;
        }
        //not a palindrome despite removing low/high character.
        return false;
      }
    }
    return true;
  }
}
