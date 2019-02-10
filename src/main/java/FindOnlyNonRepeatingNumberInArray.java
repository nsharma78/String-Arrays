/*
     There is an array with every element repeated twice except one. Find that element?
    For example if given array is {1, 1, 2, 2, 3, 4, 4, 5, 5} then your program should return 3.
     We can use a Set<Integer> but that will use extra space, XOR will do it in place

     x XOR x is 0 so for all elements present twice the result will evaluate tom 0 and when we do 0 XOR y the result will be Y which is only non repeating in array

     For instance, if your array contains the elements [3, 4, 5, 3, 4], the algorithm will return
    3 ^ 4 ^ 5 ^ 3 ^ 4
    But the XOR operator ^ is associative and commutative, so the result will be also equal to:
    (3 ^ 3) ^ (4 ^ 4) ^ 5
 */

package main.java;

public class FindOnlyNonRepeatingNumberInArray {

    public static void main(String[] args) {
        int[] arr = {3,4,5,3,4};
        System.out.println("The non repeating element in the array is: " + nonRepeating(arr));
    }

    private static int nonRepeating(int[] arr){ // O(n) O(1)
        if(arr == null)
            return -1;

        int result = 0;

        for(int i : arr)
            result = result ^ i;

        return result;
    }
}
