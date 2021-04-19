

package com.interview.lc.fb.easy.dynamic;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {
  public static void main(String[] args) {
    GridTraveller g = new GridTraveller();
    System.out.println(g.grid(1, 1, new HashMap<String, Long>()));
    System.out.println(g.grid(2, 3, new HashMap<String, Long>()));
    System.out.println(g.grid(3, 2, new HashMap<String, Long>()));
    System.out.println(g.grid(3, 3, new HashMap<String, Long>()));
    System.out.println(g.grid(10, 10, new HashMap<String, Long>()));
    System.out.println(g.grid(18, 18, new HashMap<String, Long>()));
    System.out.println(g.grid(20, 20, new HashMap<String, Long>()));
  }

  long grid(int r, int c, Map<String, Long> memo) {
    String key = r + "," + c;
    if (r == 0 || c == 0) {
      //invalid grid
      return 0;
    } else if (r == 1 && c == 1) {
      //there is only 1 way as this is 1x1 grid.
      return 1;
    } else if (memo.containsKey(key)) {
      //read it from cache
      return memo.get(key);
    }
    long ways = grid(r - 1, c, memo) + grid(r, c - 1, memo);
    memo.put(key, ways);
    return ways;
  }
}