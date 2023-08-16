package com.interview.leetcode.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinimumParanthesis {

  public static void main(String[] args) {
    MinimumParanthesis p = new MinimumParanthesis();
    System.out.println(p.minRemoveToMakeValid("))(("));
    System.out.println(p.minRemoveToMakeValid("a)b(c)d"));
    System.out.println(p.minRemoveToMakeValid("lee(t(c)o)de)"));
    System.out.println(p.minRemoveToMakeValid("(a(b(c)d)"));
  }

  public String minRemoveToMakeValid(String s) {
    StringBuffer res = new StringBuffer();

    Set<Integer> indicesToRemove = new HashSet<Integer>();
    Stack<Integer> pTracker = new Stack<Integer>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ')') {
        if (pTracker.isEmpty()) {
          indicesToRemove.add(i);
        } else {
          pTracker.pop();
        }
      } else if (c == '(') {
        pTracker.push(i);
      }
    }

    while (!pTracker.isEmpty()) {
      indicesToRemove.add(pTracker.pop());
    }

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(!indicesToRemove.contains(i)) {
        res.append(c);
      }
    }

    return res.toString();
  }
}
