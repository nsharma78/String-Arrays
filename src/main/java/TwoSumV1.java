/*
 Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
For example:
Input: numbers={8,7,2,5,3,1}, target=10
Output: (0,2) and (1,4)
----------------------------------------------------------------------------------------------------------------------------------------------
 * BIG O Details: time O(arr.length) -- space O(arr.length) to create a map
 */

package main.java;
import java.util.*;

public class TwoSumV1 {

    public static void main(String[] args) {

        //int[] arr = {8,7,2,5,3,1};
        //int[] arr = {8}; // invalid input
        int[] arr = {8,7,2,2,3,1}; //duplicates
        int sum = 10;
        List<List<Integer>> arrList = twoSum(arr, sum);

        System.out.println("Elements at the following indices adds up to the sum");
        System.out.println(arrList.toString());
    }

    private static List<List<Integer>> twoSum(int[] arr, int sum) { // O(n), O(n)

        if (arr == null || arr.length < 2) {
            System.out.println("Server response: Input validation failed, input is null");
            return Collections.emptyList();
        }

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            int elem = sum - arr[i];
            if(map.containsKey(elem)) {
                List<Integer> indices = new ArrayList<>();
                indices.add(map.get(elem));
                indices.add(i);
                list.add(indices);
            }
            else {
                map.put(arr[i], i);
            }
        }

        return list;
    }
}
