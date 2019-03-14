/*
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end,
 * such that only one letter can be changed at a time and each intermediate word must exist in the dictionary. For example, given:
	start = "hit"
	end = "cog"
	dict = ["hot","dot","dog","lot","log"]
	One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.
 */

package main.java;
import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        System.out.println(args.length);
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println("The length ofm shortest transformation is : " + getLength(start, end, dict));

    }

    static class WordNode{
        String word;
        int numSteps;

        public WordNode(String word, int numSteps){
            this.word = word;
            this.numSteps = numSteps;
        }
    }

    private static int getLength(String start, String end, Set<String> dict) {
        Queue<WordNode> wordQ = new LinkedList<>();

        wordQ.add( new WordNode(start, 1) );
        dict.add(end);
        WordNode wordNode = null;

        while(!wordQ.isEmpty()) {

            wordNode = wordQ.remove();
            if(wordNode.word.equals(end))
                return wordNode.numSteps;

            char[] arr = wordNode.word.toCharArray();
            for(int i=0; i<arr.length; i++) {
                for(char c='a'; c<='z'; c++) {
                    char temp = arr[i];
                    if(arr[i]!=c) {
                        arr[i]=c;
                    }

                    String newWord = new String(arr);
                    if(dict.contains(newWord)){
                        wordQ.add(new WordNode(newWord, wordNode.numSteps+1));
                        dict.remove(newWord);
                    }

                    arr[i]=temp;
                }
            }
        }

        return 0;
    }
}
