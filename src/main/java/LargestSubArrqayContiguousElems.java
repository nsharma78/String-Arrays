/*
 * Given an array of distinct integers, find length of the longest subarray which contains numbers that can be arranged in a continuous sequence.
    Examples:
    Input:  arr[] = {10, 12, 11};
    Output: Length of the longest contiguous subarray is 3
    Input:  arr[] = {14, 12, 11, 20};
    Output: Length of the longest contiguous subarray is 2
    Input:  arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
    Output: Length of the longest contiguous subarray is 5
 */

package main.java;

import java.util.Arrays;

public class LargestSubArrqayContiguousElems {

    public static void main(String[] args) {
        //int[] arr = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        int[] arr = {14, 12, 11, 20};
        int n = arr.length;
        System.out.println("Length of the longest contiguous subarray is " + findLength(arr, n));
    }

    private static int findLength(int[] arr, int n) { // O(nlogn) O(1)

        Arrays.sort(arr);
        int res = 1, max = 1;
        for(int i = 0; i < n; i++) {
            if(i < n-1  && arr[i + 1] - arr[i] == 1) {
                res++;
                if(res > max) max = res;
            }
            else
                res = 1;
        }
        return max;
    }
}
