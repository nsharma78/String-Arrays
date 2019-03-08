/*
 * Reverse an integer, 123456 should return as 654321,-123 should be -321, if it crosses max value of integer than return max
 */

package main.java;

public class ReverseInteger {

    public static void main(String[] args) {
        int n = -1234567;
        System.out.println("Number after reversing: " + reverseInt(n));
    }

    private static int reverseInt(int n) {
        boolean isNeg = (n < 0) ? true : false;

        long result = 0L;
        int num = Math.abs(n);

        while(num > 0) {
            int mod = num % 10;
            result = result * 10 + mod;
            num = num / 10;
        }

        return (result > Integer.MAX_VALUE) ? Integer.MAX_VALUE : ((isNeg) ? 0 -(int)result : (int)result);
    }
}
