package com.interview.lc.fb.hard;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 */
public class IntegerToEnglish {

  public static void main(String[] args) {
    IntegerToEnglish ie = new IntegerToEnglish();
    System.out.println(ie.numberToWords(0));

    System.out.println(ie.numberToWords(1));
    System.out.println(ie.numberToWords(5));
    System.out.println(ie.numberToWords(51));
    System.out.println(ie.numberToWords(99));
    System.out.println(ie.numberToWords(20));
    System.out.println(ie.numberToWords(90));


    //three
    System.out.println(ie.numberToWords(100));
    System.out.println(ie.numberToWords(105));
    System.out.println(ie.numberToWords(210));
    System.out.println(ie.numberToWords(699));

    //four
    System.out.println(ie.numberToWords(1000));
    System.out.println(ie.numberToWords(1005));
    System.out.println(ie.numberToWords(2120));
    System.out.println(ie.numberToWords(6939));

    //five
    System.out.println(ie.numberToWords(212120));
    System.out.println(ie.numberToWords(999999));

    //six
    System.out.println(ie.numberToWords(2212120));
    System.out.println(ie.numberToWords(100999999));
    System.out.println(ie.numberToWords(120000000));

    //nine
    System.out.println(ie.numberToWords(1000000000));
  }

  public String numberToWords(int num) {
    StringBuilder words = new StringBuilder();
    words.append(numberToEnglishWords(num));
    return words.toString();
  }

  //Special case
  protected String one(int num) {
    switch (num) {
      case 1:
        return "One";
      case 2:
        return "Two";
      case 3:
        return "Three";
      case 4:
        return "Four";
      case 5:
        return "Five";
      case 6:
        return "Six";
      case 7:
        return "Seven";
      case 8:
        return "Eight";
      case 9:
        return "Nine";
      default:
        return "";
    }
  }

  //Special case
  protected String lessThan20(int num) {
    switch (num) {
      case 10:
        return "Ten";
      case 11:
        return "Eleven";
      case 12:
        return "Twelve";
      case 13:
        return "Thirteen";
      case 14:
        return "Fourteen";
      case 15:
        return "Fifteen";
      case 16:
        return "Sixteen";
      case 17:
        return "Seventeen";
      case 18:
        return "Eighteen";
      case 19:
        return "Nineteen";
      default:
        return "";
    }
  }

  //Special case
  protected String tens(int num) {
    switch (num) {
      case 20:
        return "Twenty";
      case 30:
        return "Thirty";
      case 40:
        return "Forty";
      case 50:
        return "Fifty";
      case 60:
        return "Sixty";
      case 70:
        return "Seventy";
      case 80:
        return "Eighty";
      case 90:
        return "Ninety";
      default:
        return "";
    }
  }

  /**
   * The number has two digits and could be between 10 to 99
   *
   * @param num
   * @return
   */
  protected String two(int num) {
    StringBuffer words = new StringBuffer();
    if(num == 0) {
      words.append("Zero");
    } else if (num < 10) {
      words.append(one(num));
    } else if(num < 19) {
      words.append(lessThan20(num));
    } else {
      int tenthPosition = num / 10;
      int unitPosition = num - (tenthPosition * 10);

      if(unitPosition == 0) {
        words.append(tens(num));
      } else {
        words.append(tens(tenthPosition * 10)).append(" ").append(one(unitPosition));
      }
    }
    return words.toString();
  }

  protected String three(int num) {
    StringBuffer words = new StringBuffer();
    int hundrethPosition = num / 100;
    int rest = num - hundrethPosition * 100;
    if (hundrethPosition != 0) {
      words.append(one(hundrethPosition)).append(" Hundred");
      if (rest != 0) {
        words.append(" ").append(two(rest));
      }
    } else {
      words.append(two(rest));
    }
    return words.toString();
  }

  //2 000 000
  protected String numberToEnglishWords(int num) {
    StringBuffer words = new StringBuffer();
    if (num == 0)
      return "Zero";

    int billion = num / 1000000000;
    int million = (num - billion * 1000000000) / 1000000;
    int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
    int rest = num - (billion * 1000000000) - (million * 1000000) - (thousand * 1000);

    if (billion != 0) {
      words.append(three(billion)).append(" Billion");
    }
    if (million != 0) {
      if (words.length() != 0) {
        words.append(" ");
      }
      words.append(three(million)).append(" Million");
    }
    if (thousand != 0) {
      if (words.length() != 0) {
        words.append(" ");
      }
      words.append(three(thousand)).append(" Thousand");
    }
    if (rest != 0) {
      if (words.length() != 0) {
        words.append(" ");
      }
      words.append(three(rest));
    }
    return words.toString();
  }

}
