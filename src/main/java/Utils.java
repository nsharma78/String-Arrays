package main.java;

public class Utils {

    //Unfortunately Java does not support primitives for generics so have to implement for types.

    public static void reverseChar(char[] arr, int start, int end) {
        char temp;
        while(end >= start) {
            temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void reverseInt(int[] arr, int start, int end) {
        int temp;
        while(end >= start) {
            temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void swap(int[] arr, int start, int end) {
        int temp;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
