/*
 * Given two sets represented by two arrays, how to check if the given two sets are disjoint or not? It may be assumed that the given arrays have no duplicates.
Difficulty Level: Rookie
Input: set1[] = {12, 34, 11, 9, 3}
       set2[] = {2, 1, 3, 5}
Output: Not Disjoint
3 is common in two sets.
Input: set1[] = {12, 34, 11, 9, 3}
       set2[] = {7, 2, 1, 5}
Output: Yes, Disjoint
There is no common element in two sets.
 */

package main.java;
import java.util.HashSet;
import java.util.Set;

public class DisjointSets {

    public static void main(String[] args) {
        int[] set1 = {12, 34, 11, 9, 3};
        int[] set2 = {7, 2, 1, 5};

        boolean result = areDisjoint(set1, set2);
        if (result)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean areDisjoint(int[] set1, int[] set2) { //O(n+m) O(n+m)
        Set<Integer> set = new HashSet<>();
        for(int i : set1)
            set.add(i);

        for(int i : set2)
            if(set.contains(i)) return false;

        return true;
    }
}
