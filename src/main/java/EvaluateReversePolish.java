/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /.
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * -----------------------------------------------------------
 * BIG O Details: time O(arr.length) -- space O(arr.length)
 */

package main.java;
import java.util.Stack;

public class EvaluateReversePolish {

    public static void main(String[] args) {
        String[] arr = {"2", "1", "+", "3", "*"};
        //String[] arr = {"4", "13", "5", "/", "+"};
        System.out.println("The result of the expression is " +  evalReversePolish(arr));
    }

    private static String evalReversePolish(String[] arr) {

        if (arr == null || arr.length < 3)
            return null;

        String op1, op2;

        Stack<String> stk = new Stack<>();
        for(String elem : arr) {
            int tmp;
            switch(elem) {
                case "+":
                    if(!stk.isEmpty()) {
                        op1 = stk.pop();
                        op2 = stk.pop();
                        tmp = Integer.parseInt(op2) + Integer.parseInt(op1);
                        stk.push(String.valueOf(tmp));
                    }
                    break;

                case "-":
                    if(!stk.isEmpty()) {
                        op1 = stk.pop();
                        op2 = stk.pop();
                        tmp = Integer.parseInt(op2) - Integer.parseInt(op1);
                        stk.push(String.valueOf(tmp));
                    }
                    break;

                case "*":
                    if(!stk.isEmpty()) {
                        op1 = stk.pop();
                        op2 = stk.pop();
                        tmp = Integer.parseInt(op2) * Integer.parseInt(op1);
                        stk.push(String.valueOf(tmp));
                    }
                    break;

                case "/":
                    if(!stk.isEmpty()) {
                        op1 = stk.pop();
                        op2 = stk.pop();
                        tmp = Integer.parseInt(op2) / Integer.parseInt(op1);
                        stk.push(String.valueOf(tmp));
                    }
                    break;

                default:
                    stk.push(elem);
                    break;
            }
        }
        return (!stk.isEmpty()) ? stk.pop() : null;

    }
}
