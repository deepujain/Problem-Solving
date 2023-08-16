package com.interview.leetcode.easy;

public class ShortestDistanceWords {

  public static void main(String[] a) {
    ShortestDistanceWords w = new ShortestDistanceWords();
    String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    System.out.println(w.shortestDistance(words,"coding","practice"));
  }

  public int shortestDistance(String[] words, String word1, String word2) {
    int distance = Integer.MAX_VALUE;
    int w1 = -1, w2 = -1;
    for (int i = 0; i < words.length; i++) {
      if (words[i].equalsIgnoreCase(word1)) {
        w1 = i;
      } else if (words[i].equalsIgnoreCase(word2)) {
        w2 = i;
      }
      if(w1 != -1 && w2 != -1) {
        distance = Math.min(distance, Math.abs(w1 - w2));
      }
    }

    return distance;
  }
}
