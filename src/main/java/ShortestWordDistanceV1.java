/*
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 */

package main.java;

public class ShortestWordDistanceV1 {
    public static void main(String[] args) {
        String[] arr = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "coding";
        System.out.println("The distance between " + word1 + " and " + word2 + " is: " + shortestDistance(arr, word1, word2));
    }

    private static int shortestDistance(String[] words, String word1, String word2) { // O(n) O(1)
        if (words == null || words.length == 0)
            return 0;

        int minDistance = Integer.MAX_VALUE;;
        int idx1 = -1,  idx2 = -1;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                idx1 = i;
                if(idx2 != -1)
                    minDistance = Math.min(idx1 - idx2, minDistance);
            }
            else if(words[i].equals(word2)) {
                idx2 = i;
                if(idx1 != -1)
                    minDistance = Math.min(idx2 - idx1, minDistance);
            }
        }
        return minDistance;

    }
}
