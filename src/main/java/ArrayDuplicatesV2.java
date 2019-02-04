/*
 Find all duplicates from an array, example 1,2,2,4,5,5,5,6,7,8 should return 2,5,
 Input array will have only positive integers (x) with the min and max as 0 <= x <= len(array) - 1
 * -----------------------------------------------------------------------------------------------------------------------------------------------------
 * BIG O Details: time O(arr.length) -- space O(1) the key is in place with just one pass of the array, will not work for negative numbers in the array.
 * will not work for negative numbers in the array. also the numbers in the array should be less than or equal to length i.e. 0 <= x <= len(array) - 1
 * For negative numbers we can use map solution but it will use extra space.
 */

package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayDuplicatesV2 {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 3, 3, 2, 2, 2, 4, 5, 5, 5, 6, 7, 8};
        //int[] arr = new int[] {};
        System.out.println("The duplicates in the input array: " + allDuplicates(arr));
    }

    private static List<Integer> allDuplicates(int[] arr) { // O(n), O(n) where n is the length of array
        if(arr == null || arr.length < 2)
            return Collections.emptyList();

        int len = arr.length;
        List<Integer> dups = new ArrayList<>();

        for (int i : arr) {
            int value = Math.abs(i);

            if (value >= len)
                throw new RuntimeException("Invalid input");

            if(arr[value] < 0)
                dups.add(Math.abs(i));
            arr[value] = -arr[value];
        }
        return dups;
    }

}
