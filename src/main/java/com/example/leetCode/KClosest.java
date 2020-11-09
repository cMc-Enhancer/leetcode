package com.example.leetCode;

import java.util.*;

import static java.util.Arrays.asList;

public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(points.length, (o1, o2) -> o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1]);
        Collections.addAll(pq, points);
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}
