/*
    Given an array of strings, return all groups of strings that are anagrams.
    Analysis
    An anagram is a type of word play, the result of rearranging the letters of a word or phrase to produce a new word or phrase,
    using all the original letters exactly once; for example, Torchwood can be rearranged into Doctor Who.
    If two strings are anagram to each other, their sorted sequence is the same.

    arr = {"dog", "cat", "act", "god", "odg"};
    result = {{"dog", "god", "odg"}, {"cat", "act"}}
 */

package main.java;
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = {"dog", "cat", "act", "god", "odg"};
        List<List<String>> result = groupAnagrams(arr);
        System.out.println("Anagrams grouped:\n" + result.toString());
    }

    private static List<List<String>> groupAnagrams(String[] strs) { //O(n) O(n) where n is the length of array
        List<List<String>> result = new ArrayList<List<String>>();

        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        for(String str: strs){
            int key = 0;
            for(int i=0; i<str.length(); i++){
                key = key + (str.charAt(i)-'a');
            }

            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(key, al);
            }
        }

        result.addAll(map.values());

        return result;
    }
}
