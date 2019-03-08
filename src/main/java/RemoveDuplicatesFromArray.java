/*
    Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    Example:
    Given nums = [1,1,2],
    Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
    It doesn't matter what you leave beyond the new length.
 */

package main.java;

import java.util.Arrays;

public class RemoveDuplicatesFromArray {

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,3,4,4,5};
        int len = removeDuplicates(arr);
        System.out.println("The length of array after removing duplicates is: " + len);
        System.out.println("Array after removing duplicates: " + printnewArray(arr, len));
    }

    private static String printnewArray(int[] arr, int len) {

        if(len == 0)
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < len; i++)
            sb.append(arr[i] + ", ");
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    private static int removeDuplicates(int[] arr) { // O(n) O(1)
        if(arr == null)
            return -1;
        int len = arr.length;
        if( len < 2)
            return len;

        int i = 0;
        for (int j = 1; j < len; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
