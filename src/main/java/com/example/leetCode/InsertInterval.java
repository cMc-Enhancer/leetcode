package com.example.leetCode;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length < 2 || intervals == null || (intervals.length > 0 && intervals[0].length < 2)) {
            return new int[0][];
        }

        List<int[]> result = new LinkedList<>();

        boolean merged = false;
        int i;
        for (i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (!merged) {
                if (compare(interval, newInterval) == 0) {
                    mergeSecondIntervalIntoFirst(interval, newInterval);
                    newInterval = interval;
                    merged = true;
                } else if (compare(interval, newInterval) < 0) {
                    result.add(interval);
                } else {
                    break;
                }
            } else {
                if (compare(intervals[i - 1], interval) == 0) {
                    mergeSecondIntervalIntoFirst(intervals[i - 1], interval);
                    intervals[i] = intervals[i - 1];
                    newInterval = intervals[i - 1];
                } else {
                    break;
                }
            }
        }

        result.add(newInterval);

        for (; i < intervals.length; i++) {
            result.add(intervals[i]);
        }

        return result.toArray(new int[result.size()][2]);
    }

    private int compare(int[] interval, int[] anotherInterval) {
        if (interval[1] < anotherInterval[0]) {
            return -1;
        } else if (interval[0] > anotherInterval[1]) {
            return 1;
        } else {
            return 0;
        }
    }

    private void mergeSecondIntervalIntoFirst(int[] interval, int[] anotherInterval) {
        interval[0] = Math.min(interval[0], anotherInterval[0]);
        interval[1] = Math.max(interval[1], anotherInterval[1]);
    }
}
