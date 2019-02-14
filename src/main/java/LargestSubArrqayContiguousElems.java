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
import java.util.Set;
import java.util.HashSet;

public class LargestSubArrqayContiguousElems {

    public static void main(String[] args) {
        int[] arr1 = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        int[] arr2 = {14, 12, 11, 13, 20};
        int n = arr1.length;
        System.out.println("Length of the longest contiguous subarray is " + findLength1(arr1, n));
        System.out.println("Length of the longest contiguous subarray is " + findLength2(arr2));
    }

    private static int findLength1(int[] arr, int n) { // O(nlogn) O(1)

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

    private static int findLength2(int[] arr) { // O(n) O(n)

        Set<Integer> set = new HashSet<>();

        for(Integer i : arr)
            set.add(i);

        int maxLen = 1;

        for(Integer i : arr) {
            int left = i - 1;
            int right = i + 1;
            int count = 1;

            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }

            maxLen = Math.max(count, maxLen);
        }
        return maxLen;
    }
}
