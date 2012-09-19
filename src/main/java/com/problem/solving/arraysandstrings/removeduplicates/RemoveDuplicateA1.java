package com.problem.solving.arraysandstrings.removeduplicates;

/**
 * In first approach we maintain a variable called tail. At any point tail
 * points to the tail of the "non-duplicate" string, each character in string is
 * compared with all the characters in "non-duplicate" string. If a duplicate
 * character is found tail is not incremented otherwise it is. If comparison has
 * reached tail then it indicates that the new character can be added to this
 * "non duplicate" string and it is.
 * 
 */
public class RemoveDuplicateA1 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcadea".toCharArray()));
        System.out.println(removeDuplicates("abcde".toCharArray()));
        System.out.println(removeDuplicates("aaabbba".toCharArray()));
    }

    static char[] removeDuplicates(char[] input) {
        int tail = 1;
        for (int i = 1; i < input.length; i++) {
            int j;
            for (j = 0; j < tail; j++) {
                if (input[i] == input[j])
                    break;
            }
            if (j == tail) {
                input[tail] = input[i];
                tail++;
            }
        }
        for (int i = tail; i < input.length; i++) {
            input[i] = 0;
        }
        return input;
    }

}
