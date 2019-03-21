/*
 * Write a Java Program to find the second highest number in an array.
 */

package main.java;

public class SecondLargestInArray {

    public static void main(String[] args) {
        int arr[] = { 14, 46, 47, 45, 92, 52, 48, 36, 66, -85 };
        System.out.println("The second largest element is: " + find2ndLargest(arr));

    }

    private static int find2ndLargest(int[] arr) { //O(n) O(1) where n is the len gth of array

        if(arr == null || arr.length < 2) // length less than 2 no 2nd largest
            return Integer.MIN_VALUE;

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= first) {
                second = first;
                first = arr[i];
            }
            else if(arr[i] != first && arr[i] > second) {
                second = arr[i];
            }
        }
        return second;
    }
}