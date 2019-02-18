/*
     Given an array of numbers, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */

package main.java;
import java.util.*;

public class MoveZeroesToEnd {

    public static void main(String[] args) {
        int[] arr = new int[] {1,0,1,1,2,0,3,12};
        moveZeroes(arr);
        System.out.println("Arrqy after processing is: " +  Arrays.toString(arr) );
    }

    private static void moveZeroes(int[] arr) { // O(m) O(1)
        if (arr == null || arr.length < 2)
            return;

        int firstZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                Utils.swap(arr, i, firstZero++);
            }
        }
    }
}
