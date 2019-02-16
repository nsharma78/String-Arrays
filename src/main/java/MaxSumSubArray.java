/*
*   Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
    For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
    the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

package main.java;

public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("The max sum in contiguos sub array is: " + maxSumSubArray(arr) );
    }

    private static int maxSumSubArray(int[] arr) { // O(n) O(1)
        int maxSum = arr[0], maxEnding = arr[0];

        for(int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(arr[i], maxEnding + arr[i]);
            maxSum = Math.max(maxSum,  maxEnding);
        }
        return maxSum;
    }
}
