package com.interview.leetcode.easy;

/**
 * https://leetcode.com/problems/add-strings/
 */
public class AddStrings {

  public static void main(String[] args) {
    String num = "18";
    int digit = num.charAt(0) - '0';
    System.out.println(digit);
    int x = 18;
    int carry = x / 10;
    int result = x % 10;
    System.out.println(carry);
    System.out.println(result);

    AddStrings a = new AddStrings();
    System.out.println(a.addStrings("6994", "36"));
    System.out.println(a.addStrings("259", "39"));
  }

  public String addStrings(String num1, String num2) {
    StringBuilder result = new StringBuilder();
    int a = num1.length() - 1;
    int b = num2.length() - 1;
    int carry = 0;
    int res;
    while (a >= 0 && b >= 0) {
      int digitN1 = num1.charAt(a) - '0';
      int digitN2 = num2.charAt(b) - '0';
      int sum = digitN1 + digitN2 + carry;
      carry = sum / 10; //1
      res = sum % 10;   //8
      result.append(res);
      a--;
      b--;
    }

    //TODO Optimize to avoid duplicate code
    //Leftovers
    while (a >= 0) {
      int digit = num1.charAt(a) - '0';
      int sum = digit + carry;
      carry = sum / 10; //1
      res = sum % 10;   //8
      result.append(res);
      a--;
    }

    //Leftovers
    while (b >= 0) {
      int digit = num2.charAt(b) - '0';
      int sum = digit + carry;
      carry = sum / 10; //1
      res = sum % 10;   //8
      result.append(res);
      b--;
    }

    if (carry != 0) {
      result.append(carry);
    }
    return result.reverse().toString();
  }
}
