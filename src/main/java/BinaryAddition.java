/*
 Given two binary strings, return their sum (also a binary string).
 For example, a = "11", b = "1", the return is "100".

 * ---------------------------------------------------------------------------------------
 * BIG O Details: time O(s1.length() + s2.length()) -- space O(s1.length() + s2.length() )
 */

package main.java;

public class BinaryAddition {

    public static void main(String[] args) {
        String first = "1000";
        String second = "111";

        System.out.println("The sum of the given strings is: " + binaryAddition(first, second));
    }

    private static String binaryAddition(String first, String second) { // O(n+m) O(n+m) where n and m is length of strings

        if(first == null && second == null)
            return null;
        if(first == null && second != null)
            return second;
        if(first != null && second == null)
            return first;

        int len = Math.max(first.length(), second.length());
        if(len == first.length())
            second = zeroPad(len, second);
        else
            first = zeroPad(len, first);

        StringBuilder sb = new StringBuilder();
        int carry = 0, sum = 0;
        char c1, c2;
        for(int i = len - 1; i >= 0; i--) {
            c1 = first.charAt(i);
            c2 = second.charAt(i);

            sum = (c1 - '0') + (c2 - '0') + carry;
            switch(sum) {
                case 2:
                    sb.append("0");
                    carry = 1;
                    break;
                case 3:
                    sb.append("1");
                    carry = 1;
                    break;
                default:
                    sb.append(String.valueOf(sum));
                    carry = 0;
                    break;
            }

        }
        if(carry == 1)
            sb.append(String.valueOf("1"));

        return sb.reverse().toString();
    }

    private static String zeroPad(int len, String str) {
        int numZero = len - str.length();
        StringBuilder sb = new StringBuilder();
        while(numZero-- > 0)
            sb.append("0");
        return sb.append(str).toString();

    }
}
