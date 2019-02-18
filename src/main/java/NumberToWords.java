/*
    * Convert a non-negative integer to its English words representation. Given input is guaranteed to be less than 231 - 1.
     * For example,
     * 123 -> "One Hundred Twenty Three"
     * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 */

package main.java;
import java.util.*;

public class NumberToWords {

    static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        int num = 12345;
        System.out.println("The number is\n" + numberToWords(num));
    }

    private static String numberToWords(int num) {
        if (num < 0 || num > Integer.MAX_VALUE)
            return null;
        fillMap();

        StringBuilder sb =new StringBuilder();
        if(num > 1000000000) {
            int extra = num / 1000000000;
            sb.append(convert(extra) + " Billion ");
            num = num % 1000000000;
        }
        if(num > 1000000) {
            int extra = num / 1000000;
            sb.append(convert(extra) + " Million ");
            num = num % 1000000;
        }
        if(num > 1000) {
            int extra = num / 1000;
            sb.append(convert(extra) + " Thousand ");
            num = num % 1000;
        }

        if(num > 0)
            sb.append(convert(num));

        return sb.toString();

    }

    private static String convert(int extra) {
        StringBuilder sb = new StringBuilder();
        if(extra > 100) {
            int hundreds = extra / 100;
            sb.append(map.get(hundreds) + " Hundred ");
            extra = extra % 100;
        }
        if(extra > 10) {
            if(map.containsKey(extra))
                sb.append(map.get(extra));
            else {
                int tens = extra / 10;
                extra = extra % 10;
                sb.append(map.get(tens * 10) + " " + map.get(extra) );
            }

        }
        return sb.toString();
    }

    private static void fillMap() {
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
    }
}
