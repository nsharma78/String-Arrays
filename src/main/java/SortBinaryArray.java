/*
 Sort the binary array in O(n) and constant space
 Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
 Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
 */

package main.java;
import java.util.*;

public class SortBinaryArray {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        sortArray(arr);
        System.out.println("Array after sorting: " + Arrays.toString(arr));
    }

    private static void sortArray(int[] arr) { //O(n) O(1)

        if (arr == null || arr.length < 2)
            return;

        int firstOne = 0;
        for(int i = 0; i< arr.length; i++) {
            if(arr[i] == 0)
                Utils.swap(arr, i, firstOne++);
        }
    }
}
