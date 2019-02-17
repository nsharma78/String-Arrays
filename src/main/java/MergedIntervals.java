/*
    Given a unsorted collection of intervals, merge all overlapping intervals.
    For example,
    Given [1,3],[2,6],[15,18], [8,10]
    return [1,6],[8,10],[15,18].
 */

package main.java;
import java.util.*;

public class MergedIntervals {

    static class Interval{
        int start;
        int end;
        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(String.valueOf(start)).append(", ").append(String.valueOf(end)).append("]");
            return sb.toString();

        }
    }

    public static void main(String[] args) {
        int [][] arr = { {1,3}, {2,6}, {15, 18}, {8, 10} };
        List<Interval> list = new ArrayList<Interval>();
        for(int i = 0; i < arr.length; i++) {
            list.add(new Interval(arr[i][0], arr[i][1]));
        }

        List<Interval> mergedList = mergeIntervals(list);
        System.out.print("\n\nThe intervals after merging: " + mergedList.toString());
    }

    private static List<Interval> mergeIntervals(List<Interval> list) { // O(nlogn) O(n) where is the number of intervals
        if (list == null || list.isEmpty())
            return Collections.emptyList();

        //sort intervals by start value in ascending order
        Collections.sort(list, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return (Integer.valueOf(a.start)).compareTo(Integer.valueOf(b.start));
            }
        });

        List<Interval> mergedList = new ArrayList<>();
        Interval pre = list.get(0);
        list.remove(0);

        for(Interval curr : list) {
            if(curr.start > pre.end) { //no overlap
                mergedList.add(pre);
                pre = curr;
            }else {
                Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
                pre = merged;
            }
        }
        mergedList.add(pre);

        return mergedList;
    }
}
