/*
 * Given a string, Check if characters of the given string can be rearranged to form a palindrome.
 * For example characters of “geeksogeeks” can be rearranged to form a palindrome “geeksoskeeg”,
 * but characters of “geeksforgeeks” cannot be rearranged to form a palindrome.
 */

package main.java;

public class CanStringFormPalindrome {

    private static final int MAX_CHAR = 26;

    public static void main(String[] args) {
        System.out.println("geeksogeeks can form palindrome: " + canFormPalindrome("geeksogeeks"));
        System.out.println("geeksforgeeks can form palindrome: " + canFormPalindrome("geeksforgeeks"));
    }

    private static boolean canFormPalindrome(String string) { // O(n) O(26) where n is the length of string
        int[] count= new int[MAX_CHAR];
        String str = string.toLowerCase().trim();

        // For each character in input strings,increment count in the corresponding count array
        for (int i = 0; i < str.length();  i++)
            count[str.charAt(i) - 'a']++;

        // Count odd occurring characters
        int odd = 0;
        for (int i = 0; i < MAX_CHAR; i++) {
            if ((count[i] & 1) != 0)
                odd++;

            if (odd > 1)
                return false;
        }

        // Return true if odd count is 0 or 1,
        return true;
    }
}
