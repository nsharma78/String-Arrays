/*
 * Given an input string, reverse the string word by word.
 * Given s = "the sky is blue", return "blue is sky the"
 * -----------------------------------------------------------
 * BIG O Details: time O(input.length()) -- space O(1)
 */


package main.java;

public class StringReverseByWords {
    public static void main(String[] args) {

        String input = "the sky is blue"; //"test ";
        String output = strReverse(input);
        System.out.println("String after reversal is --->> " + output);
    }

    private static String strReverse(String input) {
        if (input == null || input.isEmpty())
            return input;

        String temp = input.trim();
        if(!temp.contains(" ")) // only word
            return input;

        char[] arr = temp.toCharArray();
        int j = 0, i;
        for (i = 0; i < arr.length; i++) {
            if(arr[i] == ' ') {
                Utils.reverseChar(arr, j, i - 1);
                j = i + 1;
            }
        }
        Utils.reverseChar(arr, j, i-1);
        Utils.reverseChar(arr, 0, i-1);
        return new String(arr);
    }
}
