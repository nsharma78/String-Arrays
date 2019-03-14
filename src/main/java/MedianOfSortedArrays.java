/*
Given two sorted arrays, a[] and b[], task is to find the median of these sorted arrays, in O(log(min(n, m)), when n is the number of elements in the first array, and m is the number of elements in the second array.

Prerequisite : Median of two different sized sorted arrays.

Examples :

Input : ar1[] = {-5, 3, 6, 12, 15}
        ar2[] = {-12, -10, -6, -3, 4, 10}
        The merged array is :
        ar3[] = {-12, -10, -6, -5 , -3,
                 3, 4, 6, 10, 12, 15}
Output : The median is 3.

Input : ar1[] = {2, 3, 5, 8}
        ar2[] = {10, 12, 14, 16, 18, 20}
        The merged array is :
        ar3[] = {2, 3, 5, 8, 10, 12, 14, 16, 18, 20}
        if the number of the elements are even,
        so there are two middle elements,
        take the average between the two :
        (10 + 12) / 2 = 11.
Output : The median is 11.
 */

package main.java;

public class MedianOfSortedArrays {

    static int []a = new int[]{-5, 3, 6, 12, 15};
    static int []b = new int[]{-12, -10, -6, -3, 4, 10};

    // Function to find max
    static int maximum(int a, int b) {
        return a > b ? a : b;
    }

    // Function to find minimum
    static int minimum(int a, int b) {
        return a < b ? a : b;
    }

    public static void main(String args[]) {
        int n = a.length;
        int m = b.length;

        // we need to define the
        // smaller array as the
        // first parameter to
        // make sure that the
        // time complexity will
        // be O(log(min(n,m)))
        if (n < m)
            System.out.print("The median is : " + findMedianSortedArrays(n, m));
        else
            System.out.print("The median is : " + findMedianSortedArrays(m, n));
    }

    static double findMedianSortedArrays(int n, int m) { //O(log(min(n, m)) O(1)

        int min_index = 0, max_index = n, i = 0, j = 0, median = 0;

        while (min_index <= max_index) {
            i = (min_index + max_index) / 2;
            j = ((n + m + 1) / 2) - i;

            // if i = n, it means that Elements
            // from a[] in the second half is an
            // empty set. and if j = 0, it means
            // that Elements from b[] in the first
            // half is an empty set. so it is
            // necessary to check that, because we
            // compare elements from these two
            // groups. Searching on right
            if (i < n && j > 0 && b[j - 1] > a[i])
                min_index = i + 1;

                // if i = 0, it means that Elements
                // from a[] in the first half is an
                // empty set and if j = m, it means
                // that Elements from b[] in the second
                // half is an empty set. so it is
                // necessary to check that, because
                // we compare elements from these two
                // groups. searching on left
            else if (i > 0 && j < m && b[j] < a[i - 1])
                max_index = i - 1;

                // we have found the desired halves.
            else {
                // this condition happens when we
                // don't have any elements in the
                // first half from a[] so we
                // returning the last element in
                // b[] from the first half.
                if (i == 0)
                    median = b[j - 1];

                    // and this condition happens when
                    // we don't have any elements in the
                    // first half from b[] so we
                    // returning the last element in
                    // a[] from the first half.
                else if (j == 0)
                    median = a[i - 1];
                else
                    median = maximum(a[i - 1],
                            b[j - 1]);
                break;
            }
        }

        // calculating the median.
        // If number of elements is odd
        // there is one middle element.
        if ((n + m) % 2 == 1)
            return (double)median;

        // Elements from a[] in the
        // second half is an empty set.
        if (i == n)
            return (median + b[j]) / 2.0;

        // Elements from b[] in the
        // second half is an empty set.
        if (j == m)
            return (median + a[i]) / 2.0;

        return (median + minimum(a[i],
                b[j])) / 2.0;
    }
}
