package com.example.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            map.putIfAbsent(i, 0);
            map.computeIfPresent(i, (k, v) -> v + 1);
        }

        return map.size() == new HashSet<>(map.values()).size();
    }
}
