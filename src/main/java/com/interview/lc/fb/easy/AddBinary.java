package com.interview.lc.fb.easy;

/**
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary {
  public static void main(String[] args) {
    String num = "0101";
    int digit = num.charAt(1) - '0';
    System.out.println(digit);
    int x = 1;
    int carry = x / 2;
    int result = x % 2;
    System.out.println(carry);
    System.out.println(result);

    AddBinary a = new AddBinary();
    System.out.println(a.addBinary("11", "1"));
    System.out.println(a.addBinary("1010", "1011"));
  }

  public String addBinary(String num1, String num2) {
    StringBuilder result = new StringBuilder();
    int a = num1.length() - 1;
    int b = num2.length() - 1;
    //carry is 0 or 1
    int carry = 0;
    int res;
    while (a >= 0 && b >= 0) {
      int digitN1 = num1.charAt(a) - '0';
      int digitN2 = num2.charAt(b) - '0';
      int sum = digitN1 + digitN2 + carry;
      carry = sum / 2;
      res = sum % 2;
      result.append(res);
      a--;
      b--;

    }

    //Leftovers
    while (a >= 0) {
      int digit = num1.charAt(a) - '0';
      int sum = digit + carry;
      carry = sum / 2; //1
      res = sum % 2;   //8
      result.append(res);
      a--;
    }

    //Leftovers
    while (b >= 0) {
      int digit = num2.charAt(b) - '0';
      int sum = digit + carry;
      carry = sum / 2; //1
      res = sum % 2;   //8
      result.append(res);
      b--;
    }

    if (carry != 0) {
      result.append(carry);
    }

    return result.reverse().toString();
  }
}
