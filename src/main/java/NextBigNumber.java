/*
     Given an array of positive integers, return the array with next big number
     Ex {1,0,1,2,9} should return {1,0,1,9,2}
     Ex {2,3,9,8,7} should return (2,7,3,8,9}
 */

package main.java;
import java.util.*;

public class NextBigNumber {

    public static void main(String[] args) {
        //int[] arr = new int[] {1,0,1,2,9};
        int[] arr = new int[] {2,3,9,8,7};
        //int[] arr = new int[] {};
        nextBigNumber(arr);
        System.out.println("Array with the next big number is : " + Arrays.toString(arr));
    }

    private static void nextBigNumber(int[] arr) {
        if(arr == null || arr.length < 2)
            return;
        int i = 0;
        int len = arr.length;
        for (i = len - 1; i >= 0; i--) {
            if(arr[i -1 ] < arr[i])
                break;
        }

        if(i == 0)
            System.out.println("No bigger number possible");
        else {
            int pivot = arr[i- 1], min = i;

            for (int j = i + 1; j < len; j++) {
                if (arr[j] > pivot && arr[j] < arr[min]) {
                    min = j;
                }
            }
            Utils.swap(arr, i - 1, min);

            Utils.reverseInt(arr, i, len-1);
        }
    }

}
