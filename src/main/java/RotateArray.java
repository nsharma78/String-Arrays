/*
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [4,5,6,7,1,2,3]
 * --------------------------------------------------------------------------------------------
 * BIG O Details: time O(arr.length) -- space O(1)
 */

package main.java;
import java.util.*;

public class RotateArray {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        rotateArray(arr, k);

        System.out.println("Array after rotation is " + Arrays.toString(arr));
    }

    private static void rotateArray(int[] arr, int k) { // O(n) O(1)
        if (arr == null || arr.length < k) {
            System.out.println("Check input and try again");
            return;
        }

        Utils.reverseInt(arr, 0, k-1);
        Utils.reverseInt(arr, k, arr.length - 1);
        Utils.reverseInt(arr, 0, arr.length - 1);
    }
}
