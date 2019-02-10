/*
Give an array and a sum, count the number of pairs in that array that sums upto the given sum.
Ex: {1, 5, 7, -1, 5} ;
sum = 6;

Number of pairs = 3

 */

package main.java;
import java.util.*;

public class GivenSumCountPairs {

    public static void main(String[] args) {
        int arr[] = {1, 5, 7, -1, 5} ;
        int sum = 6;
        System.out.println("Count of pairs is " + getPairsCount(arr, arr.length,sum));

    }

    private static int getPairsCount(int[] arr, int n, int sum) {
        Map<Integer, Integer> hm = new HashMap<>();

        // Store counts of all elements in map hm
        for (int i = 0; i < n; i++) {
            if(!hm.containsKey(arr[i]))
                hm.put(arr[i], 0);
            hm.put(arr[i], hm.get(arr[i]) + 1);
        }
        int twiceCount = 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i = 0; i < n; i++) {
            if(hm.get(sum - arr[i]) != null)
                twiceCount += hm.get(sum - arr[i]);

            if (sum-arr[i] == arr[i])
                twiceCount--;
        }

        // return the half of twice_count
        return twiceCount/2;
    }
}
