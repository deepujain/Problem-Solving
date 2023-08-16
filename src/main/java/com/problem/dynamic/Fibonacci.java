package com.problem.dynamic;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

  public static void main(String[] args) {

    Fibonacci f = new Fibonacci();
    Map<Integer, Integer> memo = new HashMap<>();
    System.out.println(f.fib(3, memo));
    System.out.println(f.fib(4, memo));
    System.out.println(f.fib(5, memo));
    System.out.println(f.fib(40, memo ));
  }

  public int fib(int n, Map<Integer, Integer> memo) {
    if (n <= 2) return 1;
    if (memo.containsKey(n)) {
      return memo.get(n);
    }
    int result = fib(n - 1, memo) + fib(n - 2, memo);
    memo.put(n, result);
    return result;
  }
}
