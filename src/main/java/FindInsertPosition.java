/*
     Given a sorted array and a target value, return the index if the target is found.
     If not, return the index where it would be if it were inserted in order. You may assume no duplicates in the array.
    Here are few examples.
    [1,3,5,6], 5 -> 2
    [1,3,5,6], 2 -> 1
    [1,3,5,6], 7 -> 4
    [1,3,5,6], 0 -> 0
     */

package main.java;

public class FindInsertPosition {

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int index = findInsertPosition(arr, 4);
        System.out.println("The element is present/will  be inserted at the position: " + index);
    }

    private static int findInsertPosition (int[] arr, int target) { // O(logn) O(1)
        if(arr == null || target < arr[0])
            return 0;
        if(target > arr[arr.length -1])
            return arr.length;

        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;

        while(lo <= hi){
            mid = lo + (hi - lo)/2;
            if(arr[mid] > target)
                hi = mid - 1;
            else if(arr[mid] < target)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }
}
