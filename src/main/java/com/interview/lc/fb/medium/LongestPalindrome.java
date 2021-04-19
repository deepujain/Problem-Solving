package com.interview.lc.fb.medium;

public class LongestPalindrome {
  public static void main(String[] args) {
    LongestPalindrome a = new LongestPalindrome();

    a.isPalindrome("racecar",0,0 );
    a.isPalindrome("abba",0,1);

  }

  public int isPalindrome(String s, int l, int r) {
    while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }
    return r - l - 1;
  }


}
