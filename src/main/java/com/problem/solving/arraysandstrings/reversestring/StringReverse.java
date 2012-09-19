package com.problem.solving.arraysandstrings.reversestring;

/**
 * Reverse a string without using built in functions. A character at index i
 * would occupy a location n-i-1 in reversed string. Hence all that needs to be
 * done in each iteration is to swamp(i, n-i-1) and this should be done n/2
 * times.
 */
public class StringReverse {

    public static void main(String[] args) {
        StringReverse s = new StringReverse();
        System.out.println(s.reverse("abcde".toCharArray()));
        System.out.println(s.reverse("abcdef".toCharArray()));
        System.out.println(s.reverse("".toCharArray()));
    }

    public char[] reverse(char input[]) {
        int length = input.length;
        for (int i = 0; i < length / 2; i++) {
            swap(i, length - i - 1, input);
        }
        return input;
    }

    private void swap(int src, int dest, char[] input) {
        char temp = input[src];
        input[src] = input[dest];
        input[dest] = temp;
    }
}
