/*
 Given an array of integers, which can contain both +ve and -ve numbers.  maximize the product of any 3 elements of the array. The elements can be non-contiguous.
Some examples:
int[] arr = {-5, -7, 4, 2, 1, 9};  // Max Product of 3 numbers = -5 * -7 * 9
int[] arr2 = {4, 5, -19, 3};       // Max Product of 3 numbers = 4 * 5 * 3
* --------------------------------------------------------------------------------------------------------
* BIG O Details: time O(arr.length) -- space O(1) the key is in place with just one pass of the array,
*
 */


package main.java;

public class MaxProductOf3Numbers {

    public static void main(String[] args) {
        int[] arr = {-5,-7,4,2,1,9};
        //int[] arr = {4,5,-19, 3};

        System.out.print("Max product of 3 numbers is: " + maxProduct3Numbers(arr));
    }

    private static long maxProduct3Numbers(int[]  arr) { // O(n) O(1)
        if(arr == null || arr.length < 3)
            throw new RuntimeException("Invalid input");

        int great = Integer.MIN_VALUE, greater = Integer.MIN_VALUE, greatest = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE, smaller = Integer.MAX_VALUE, smallest = Integer.MAX_VALUE;

        for(int i : arr) {
            if(i > greatest) {
                great = greater;
                greater = greatest;
                greatest = i;
            }else if(i > greater) {
                great = greater;
                greater = i;
            }else if(i > great) {
                great = i;
            }

            if(i <= smallest) {
                small = smaller;
                smaller = smallest;
                smallest = i;
            }else if(i < smaller) {
                small = smaller;
                smaller = i;
            }else if(i < small) {
                small = i;
            }

        }
        long prod1 = greatest * greater * great;
        long prod2 = greatest * smaller * smallest;

        return (prod1 > prod2) ? prod1 : prod2;
    }
}
