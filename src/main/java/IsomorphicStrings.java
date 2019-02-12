/*
 * Given two strings s and t, determine if they are isomorphic.
 * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 * ----------------------------------------------------------------------------------------
 * BIG O Details: time O(string1.length() + string2.length()) -- space O(string1.length())
 */

package main.java;
import java.util.*;

public class IsomorphicStrings {

    public static void main(String[] args) {

        String str1 = "abcdabcdabc";//"foo";//null;//"egg";
        String str2 = "wxyzwxyzwxy";//"bar";//null;//"add";
        boolean result = isIsomorphic(str1, str2);

        String resultStr = (result == true) ? "isomorphcic" : "not isomorphic";
        System.out.println(str1 + " and " + str2 + " are " + resultStr);
    }

    private static boolean isIsomorphic(String str1, String str2) { // O(n) O(n) where n is the length of strings
        if (str1 == null && str2 == null)
            return true;
        if ((str1 == null && str2 != null) || (str1 != null && str2 == null))
            return false;
        if (str1.length() != str2.length())
            return false;

        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < str1.length(); ++i) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if(map.containsKey(c1)) {
                if(map.get(c1) != c2)
                    return false;
            }
            else {
                map.put(c1, c2);
            }
        }
        return true;
    }
}
