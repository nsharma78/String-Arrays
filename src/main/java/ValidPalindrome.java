/*
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is awesome" is not.
    Note:
    Have you consider that the string might be empty? This is a good question to ask during an interview.
    For the purpose of this problem, we define empty string as valid palindrome.
 */

package main.java;

public class ValidPalindrome {

    public static void main(String[] args) {
        String input1 = "Red rum, sir, is murder";
        String input2 = "Programcreek is awesome";

        System.out.println("The string " + input1 + " is valid palindrome: " + isValidPalindrome(input1));
    }

    private static boolean isValidPalindrome(String str) { // O(n) O(1)
        if (str == null || str.isEmpty())
            return true;

        String input = str.toLowerCase();

        int i = 0, j = input.length() - 1;
        while(i <= j) {
            char c1 = input.charAt(i);
            char c2 = input.charAt(j);

            if(!Character.isLetter(c1) && !Character.isDigit(c1)) {
                i++;
                continue;
            }

            if(!Character.isLetter(c2) && !Character.isDigit(c2)) {
                j--;
                continue;
            }
            if(c1 != c2)
                return false;
            i++;
            j--;
        }
        return true;
    }
}
