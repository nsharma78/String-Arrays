/*
     Given a number n, write a function that generates and prints all binary numbers with decimal values from 1 to n.
    Examples:
    Input: n = 2
    Output: 1, 10
    Input: n = 5
    Output: 1, 10, 11, 100, 101
 */

package main.java;

import java.util.*;

public class GenerateBinaryNumbers {

    public static void main(String[] args) {
        int n = 5;
        List<String> numbers = generate1(n);
        System.out.println("Binary numbers generated are\n" + numbers.toString());
        numbers = generate2(8);
        System.out.println("Binary numbers generated are\n" + numbers.toString());
    }

    private static List<String> generate1(int n) { // O(n), O(n)
        if(n < 1)
            return Collections.emptyList();

        List<String> list = new ArrayList<>();
        list.add("1");
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int tmp = i;
            while(tmp > 0) {
                sb.append(tmp % 2);
                tmp = tmp / 2;
            }
            list.add(sb.reverse().toString());
        }
        return list;
    }

    private static List<String> generate2(int n) { // O(n), O(n)
        if(n < 1)
            return Collections.emptyList();

        List<String> list = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");

        String str;

        while(n-- > 0){
            str = q.remove();
            list.add(str);
            q.add(str + "0");
            q.add(str + "1");
        }
        return list;
    }
}
