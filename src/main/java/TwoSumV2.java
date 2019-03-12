/*
 Design and implement a TwoSum class. It should support the following operations: add and find.
add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.
For example,
add(1);
add(3);
add(5);
find(4) -> true
find(7) -> false
----------------------------------------------------------------------------------------------------------------------------------------------
 * BIG O Details: time O(n) -- space O(n) to create a map
 */

package main.java;
import java.util.*;

import java.util.HashMap;

public class TwoSumV2 {

    public static void main(String[] args) {
        TwoSumV2 obj = new TwoSumV2();
        obj.add(2);
        obj.add(1);
        obj.add(5);
        System.out.print(obj.find(4));
        System.out.println();
        System.out.print(obj.find(7));

    }

    private Map<Integer, Integer> map;

    public TwoSumV2() {
        map = new HashMap<>();
    }

    public void add(int num) {
        if(map.containsKey(num))
            map.put(num,  map.get(num) + 1);
        else
            map.put(num,  1);
    }

    private boolean find(int sum) {
        if(map.isEmpty())
            return false;

        int target;
        for(Integer i : map.keySet()) {
            target = sum - i;
            if(map.containsKey(target)) {
                // this condition captures input where you have add(2), add(1), find(4) without this it will return true which is not correct
                if( i == target && map.get(target) < 2 )
                    continue;
                return true;
            }
        }
        return false;
    }
}
