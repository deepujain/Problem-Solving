package com.interview.lc.fb.easy;

/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/submissions/
 */
public class AlienOrderLex {

  public static void main(String[] a) {
    AlienOrderLex s = new AlienOrderLex();
    System.out.println(s.isAlienSorted(new String[]{"father","fat"},"abcdefghijklmnopqrstuvwxyz"));
    System.out.println(s.isAlienSorted(new String[]{"hello","leetcode"},"hlabcdefgijkmnopqrstuvwxyz"));
    System.out.println(s.isAlienSorted(new String[]{"word","world","row"},"worldabcefghijkmnpqstuvxyz"));
    System.out.println(s.isAlienSorted(new String[]{"apple","app"},"abcdefghijklmnopqrstuvwxyz"));
  }

  public boolean isAlienSorted(String[] words, String order) {
    int[] english_to_alien_map = new int[26];
    for(int i=0; i<order.length(); i++) {
      english_to_alien_map[order.charAt(i) - 'a'] = i;
    }

    for(int i=1; i< words.length; i++) {
      if(compare(words[i-1], words[i], english_to_alien_map) > 0) {
        return false;
      }
    }
    return true;
  }

  //
  // Return -ve when word1 < word2
  // Return +ve when word1 > word2
  // Return  0 when word1 == word2
  //
  int compare(String word1, String word2, int[] english_to_alien_map) {
    int i=0;
    int j=0;
    int compare=0;
    while(i < word1.length() && j < word2.length() && compare == 0) {
      char c1 = word1.charAt(i);
      char c2 = word2.charAt(j);
      //c1-'a' the subtration is done to start from the top of the array at 0 index
      compare = english_to_alien_map[c1-'a'] - english_to_alien_map[c2-'a'];
      i++;
      j++;
    }
    if(compare == 0) {
      return word1.length() - word2.length();
    } else {
      return compare;
    }
  }

}
