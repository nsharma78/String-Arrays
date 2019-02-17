/*
 * Given two sorted iterators, merge their inputs into a single stream.
 *
 * Iterator<Integer> a = [0, 2, 4, 6,...];
 * Iterator<Integer> b = [1, 3, 5, 7,...];
 *
 * Iterator<Integer> c = new MergedIterator<>(a, b);
 *  while (c.hasNext()) {
 *    System.out.println(c.next())
 *  }
 *
 * This should print "0", then "1", then "2", then "3", up until Integer.MAX_INT.
 */

package main.java;
import java.util.*;

public class MergedIterator {

    private Iterator<Integer> even;
    private Iterator<Integer> odd;
    private Integer topEven = null;
    private Integer topOdd = null;

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(0,2,4,6,8,10);
        List<Integer> list2 = Arrays.asList(1,3,5,7,9,11);

        Iterator<Integer> itr1 = list1.iterator();
        Iterator<Integer> itr2 = list2.iterator();

        MergedIterator itr =new MergedIterator(itr1, itr2);
        while(itr.hasNext())
            System.out.println(itr.next());
    }

    public MergedIterator(Iterator<Integer> itr1, Iterator<Integer> itr2) {
        even = itr1;
        odd = itr2;
        if (even.hasNext())
            topEven = even.next();
        if (odd.hasNext())
            topOdd = odd.next();
    }

    private boolean hasNext() {
        return (topEven != null || topOdd != null);
    }

    public Integer next() {
        if(topEven == null && topOdd != null){
            int temp = topOdd;
            if(odd.hasNext())
                topOdd = odd.next();
            else
                topOdd = null;
            return temp;
        }
        if(topEven != null && topOdd == null){
            int temp = topEven;
            if(even.hasNext())
                topEven = even.next();
            else
                topEven = null;
            return temp;
        }
        if(topEven < topOdd){
            int temp = topEven;
            if(even.hasNext())
                topEven = even.next();
            else
                topEven = null;
            return temp;
        }else {
            int temp = topOdd;
            if(odd.hasNext())
                topOdd = odd.next();
            else
                topOdd = null;
            return temp;
        }

    }
}
