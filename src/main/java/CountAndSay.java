/*
 The count-and-say sequence is the sequence of integers beginning as follows:
	1, 11, 21, 1211, 111221, ...

	1 is read off as "one 1" or 11.
	11 is read off as "two 1s" or 21.
	21 is read off as "one 2, then one 1" or 1211.
	1211 is read off as "one 1, one 2, then two 1" or 111221.
	111221 is read off as "three 1s, two 2s, then one 1" or 1112211
	1112211 is read off as "three 1s, two 2s, then two 1s" or 312211
	312211 is read off as "one 3, one 1, two 2s, then two 1s" or 13112211
	Given an integer n, generate the nth sequence.
 */

package main.java;

public class CountAndSay {

    public static void main(String[] args) {
        int n = 5;
        String str = countAndSay(n);
        System.out.println("The string for count and say is: " + str);
    }

    private static String countAndSay(int n) { // O(n) O(1)
        if (n <= 0)
            return null;

        String result = "1";
        int i = 1;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }

        return result;
    }
}
