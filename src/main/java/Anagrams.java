/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.
 */

package main.java;

public class Anagrams {
    public static void main(String[] args) {
        String first = "williamshakespeare";
        String second = "iamaweakishspeller";

        System.out.print("The words " + first + " and " + second + " are anagrams: " + areWeAnagrams(first, second));
    }

    private static boolean areWeAnagrams(String s, String t){ // O(n+m), O(28) where n and m is length of the strings
        if(s.length() != t.length())
            return false;
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c - 'a']++;
        }
        for (char c : t.toCharArray()){
            arr[c - 'a']--;
        }
        for(int i : arr){
            if(i > 0)
                return false;
        }
        return true;
    }
}
