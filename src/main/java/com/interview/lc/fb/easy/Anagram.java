package com.interview.lc.fb.easy;

public class Anagram {
  public static void main(String[] args) {
    Anagram a = new Anagram();
    System.out.println(a.isAnagram("cat", "rac"));
    System.out.println(a.isAnagram("anagram", "nagaram"));
  }

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
      //1. Get ASCII value of each character
      //2. Subtract with 'a' to find the index in the counter.
      //3. Increment the value at that index within counter for "s"
      //4. Increment the value at that index within counter for "t"
      counter[s.charAt(i) - 'a']++;
      counter[t.charAt(i) - 'a']--;
    }

    //Any value within counter is > 0 then this is not anagram
    for (int i = 0; i < counter.length; i++) {
      if (counter[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
