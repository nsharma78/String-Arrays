/*
 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.
           _
         _| |
        |/|/|
        |/|/|  _
     _  |/|/|_| |
    | |_|/|/| | |
    |_|_|/|/|_|_|
 */

package main.java;
import java.util.*;

public class HistogramLargestRectangle {

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        int area = getMaxArea(arr);
        System.out.println("The max area for a rectangle in the histogram is: " + area);
    }

    private static int getMaxArea(int[] arr) {
        if(arr == null || arr.length < 1)
            return 0;
        if(arr.length == 1)
            return arr[0];

        int i = 0, top = 0, area = 0, maxArea = 0;
        Stack<Integer> stk = new Stack<>();

        while(i < arr.length) {
            if(stk.isEmpty() || arr[stk.peek()] <= arr[i])
                stk.push(i++);
            else {
                top = stk.pop();
                if(stk.isEmpty())
                    area = arr[top] * i;
                else
                    area = arr[top] * (i - stk.peek() - 1);

                if(area > maxArea)
                    maxArea = area;
            }
        }

        while(!stk.isEmpty()) {
            top = stk.pop();
            if(stk.isEmpty())
                area = arr[top] * i;
            else
                area = arr[top] * (i - stk.peek() - 1);

            if(area > maxArea)
                maxArea = area;
        }

        return maxArea;
    }
}
