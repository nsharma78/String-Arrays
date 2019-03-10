/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
Examples:
Input: arr[]   = {2, 0, 2}
Output: 2
Structure is like below
| |
|_|
We can trap 2 units of water in the middle gap.
Input: arr[]   = {3, 0, 0, 2, 0, 4}
Output: 10
Structure is like below
     |
|    |
|  | |
|__|_|
We can trap "3*2 units" of water between 3 an 2,
"1 unit" on top of bar 2 and "3 units" between 2
and 4.  See below diagram also.
Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Output: 6
       |
   |   || |
_|_||_||||||
Trap "1 unit" between first 1 and 2, "4 units" between
first 2 and 3 and "1 unit" between second last 1 and last 2
 */

package main.java;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[]  arr = {3, 0, 0, 2, 0, 4};
        System.out.println("Amount of water that can be trapped with bars from given array is: " + trapRainWater(arr));
    }

    private static int trapRainWater(int[] arr) { // O(n) O(n)
        if(arr == null || arr.length == 0)
            return 0;
        int result = 0;
        int len = arr.length;

        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = arr[0];
        for(int i = 1 ; i < len; i++)
            left[i] = Math.max(left[i - 1], arr[i]);

        right[len - 1] = arr[len - 1];
        for(int i = len - 2 ; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);

        for (int i = 0; i < len; i++)
            result = result +  Math.min(left[i],right[i]) - arr[i];
        return result;
    }
}
