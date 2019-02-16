/*
 Given a list of non negative integers, arrange them such that they form the largest number.
For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
(Note: The result may be very large, so you need to return a string instead of an integer.)
 */

package main.java;

import java.util.Arrays;
import java.util.Comparator;

public class MakeLargestPossibleNumber {

    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        System.out.println("The largest number made from the array is: " + largestNumber(arr));
    }

    private static String largestNumber(int[] arr) { // O(nlogn) O(n)
        if (arr == null || arr.length == 0)
            return null;

        String[] strArray = new String[arr.length];
        for (int i = 0; i < arr.length; i++)
            strArray[i] = String.valueOf(arr[i]);

        Arrays.sort(strArray, new Comparator<String>() {
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });

        System.out.println(Arrays.toString(strArray));
        StringBuilder sb = new StringBuilder();
        for(String str : strArray)
            sb.append(str);
        if(sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}
