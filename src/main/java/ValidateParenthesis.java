/*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

package main.java;
import java.util.*;

public class ValidateParenthesis {

    public static void main(String[] args) {
        String[] inputs = {"(){}[]","(]{}[]","([])","([)]"};
        for(String input : inputs)
            System.out.println("The string " + input + " is valid: " + isValid(input));
    }

    private static boolean isValid(String input) {
        if (input == null || input.length() == 0)
            return true;

        int len = input.length();
        if(len < 2)
            return false;

        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < len; i++) {
            char c = input.charAt(i);
            switch(c) {
                case')':
                    if(stk.isEmpty() || stk.pop() != '(' )
                        return false;
                    break;
                case'}':
                    if(stk.isEmpty() || stk.pop() != '{' )
                        return false;
                    break;
                case']':
                    if(stk.isEmpty() || stk.pop() != '[' )
                        return false;
                    break;
                default:
                    stk.push(c);
                    break;
            }
        }
        return(stk.isEmpty());
    }

}
