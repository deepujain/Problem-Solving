package com.interview.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortByFrequency {

  public static void main(String[] args) {
    SortByFrequency a = new SortByFrequency();
    //output: aaccrt
    System.out.println(a.frequencySort("catrac"));
    System.out.println(a.frequencySort("bbuuuatbllagtv"));
  }

  public String frequencySort(String s) {
    //Count characters
    Map<Character, Integer> counter = new HashMap<Character, Integer>();
    for (char c : s.toCharArray()) {
      counter.put(c, counter.getOrDefault(c, 0) + 1);
    }

    //Create a max heap
    //PriorityQueue<Character> minHeap = new PriorityQueue<>( (c1,c2) -> counter.get(c1) - counter.get(c2) );
    PriorityQueue<Character> maxHeap = new PriorityQueue<>( (c1,c2) -> counter.get(c2) - counter.get(c1) );
    maxHeap.addAll(counter.keySet());

    //Remove from maxHeap and append to StringBuild (efficient)
    StringBuilder output = new StringBuilder();
    while (!maxHeap.isEmpty()) {
      char c = maxHeap.remove();
      for(int i=0;i<counter.get(c);i++) {
        output.append(c);
      }
    }

    return output.toString();
  }


}

