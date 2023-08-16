package com.interview.leetcode.easy.dynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
/*
public class MinimumKnightMoves {

  public static void main(String[] args) {
    MinimumKnightMoves m = new MinimumKnightMoves();
    System.out.println(m.minimumMoves(-2,1));
  }


  public int minimumMoves(int x, int y) {
    List<Pair<Integer, Integer>> knightMoves = new ArrayList();
    knightMoves.add(new Pair(2, 1));
    knightMoves.add(new Pair(-2, 1));
    knightMoves.add(new Pair(2, -1));
    knightMoves.add(new Pair(-2, -1));
    knightMoves.add(new Pair(1, 2));
    knightMoves.add(new Pair(-1, 2));
    knightMoves.add(new Pair(1, -2));
    knightMoves.add(new Pair(-1, -2));
    int absX = Math.abs(x);
    int absY = Math.abs(y);

    Set<String> visited = new HashSet<>();
    Queue<Pair<Integer, Integer>> positions = new LinkedList<>();
    positions.add(new Pair<>(0, 0));

    int moves = 0;
    while (!positions.isEmpty()) {
      int totalMoves = positions.size();
      for (int i = 0; i < totalMoves; i++) {
        Pair<Integer, Integer> curPos = positions.remove();
        if (curPos.getKey() == absX && curPos.getValue() == absY) {
          return moves;
        } else {
          for (Pair<Integer, Integer> move : knightMoves) {
            Integer newX = curPos.getKey() + move.getKey();
            Integer newY = curPos.getValue() + move.getValue();

            if (!visited.contains(newX + "," + newY)) {
              visited.add(newX + "," + newY);
              positions.add(new Pair<>(newX, newY));
            }
          }
        }
      }
      moves++;
    }
    return moves;
  }
}
*/