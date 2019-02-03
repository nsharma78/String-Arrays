/*
 * Given a pair of integers where first member is child of second,
 * Ex {{1,2}, {1,3}, {3,4}, {5.6}, {5,7}, {6,8}}
 *
 *        4   8   9
 *       /   /   /
 *  2   3   6   7
 *   \ /     \ /
 *    1       5
 * return two lists, once which has the elements with elements who has exactly 1 parent [3,6,7]
 * Second list should have elements which does not have any parent [2,4,8,9]
 *
 */

package main.java;

import java.util.*;

public class Ancestors {

    public static void main(String[] args) {
        int[][] arr = {{1,2}, {1,3}, {3,4}, {5,6}, {5,7}, {6,8}, {7,9}};
        List<List<Integer>> result = ancestors(arr);
        System.out.println("Elements with exactly one parent: " + result.get(0).toString());
        System.out.println("Elements with no parent: " + result.get(1).toString());
    }

    private static List<List<Integer>> ancestors(int[][] arr){
        if(arr == null ||arr.length == 0)
            return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i][0])) {
                List<Integer> list = map.get(arr[i][0]);
                list.add(arr[i][1]);
                map.put(arr[i][0], list);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i][1]);
                map.put(arr[i][0], list);
            }
            List<Integer> emptyList = new ArrayList<>();
            map.put(arr[i][1], emptyList);
        }

        List<Integer> oneParent = new ArrayList<>();
        List<Integer> noParent = new ArrayList<>();

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if(entry.getValue().size() == 0)
                noParent.add(entry.getKey());
            if(entry.getValue().size() == 1)
                oneParent.add(entry.getKey());
        }

        result.add(oneParent);
        result.add(noParent);

        return result;
    }
}
