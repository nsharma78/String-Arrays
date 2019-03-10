/*
    Given a digit string, return all possible letter combinations that the number could represent.
    A mapping of digit to letters (just like on the telephone buttons) is given below.
    Input:Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

package main.java;
import java.util.*;

public class StringsFromPhoneKeyPad {

    public static void main(String[] args) {
        String input = "246";
        List<String> list = wordsFromPhoneKeyPad(input);
        System.out.println(list.size() + " The words formed from given digits are: " + list.toString());
    }

    private static List<String> wordsFromPhoneKeyPad(String digits) {
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> list = new LinkedList<>();
        list.add("");

        for(int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - '2';
            if(index < 0 || index > letters.length)
                continue;
            int size = list.size();
            for (int k = 0; k < size; k++) {
                String tmp = list.remove();
                for(int j = 0; j < letters[index].length(); j++) {
                    list.add(tmp + letters[index].charAt(j));
                }
            }
        }
        return list;
    }
}
