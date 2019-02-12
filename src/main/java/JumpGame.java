/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return false.
 */

package main.java;

public class JumpGame {

    public static void main(String[] args) {
        int[]  arr = {2,3,1,1,4};
        //int[]  arr = {3,2,1,0,4};
        System.out.println("Can reach last index?: " + canReach(arr));
    }

    private static boolean canReach(int[] arr) { // O(n) O(1) where n is the length of array
        if (arr == null || arr.length == 0)
            return false;

        for(int i = 0; i < arr.length;) {
            i = i + arr[i];
            if(i <= arr.length && arr[i] == 0)
                return false;
        }
        return true;
    }
}
