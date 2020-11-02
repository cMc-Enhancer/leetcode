package com.example.leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        List<Integer> result = new LinkedList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i = fastSkip(nums1, i);
                j = fastSkip(nums2, j);
            } else if (nums1[i] < nums2[j]) {
                i = fastSkip(nums1, i);
            } else {
                j = fastSkip(nums2, j);
            }
        }

        int[] ans = new int[result.size()];
        int index = 0;
        for (Integer v : result) {
            ans[index] = v;
            index++;
        }
        return ans;
    }

    private int fastSkip(int[] array, int index) {
        int skippedIndex = index + 1;
        while (skippedIndex > 0 && skippedIndex < array.length && array[skippedIndex] == array[skippedIndex - 1]) {
            skippedIndex++;
        }
        return skippedIndex;
    }

    public int[] streamSolution(int[] nums1, int[] nums2) {
        Set<Integer> integers = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(integers::contains).toArray();
    }
}
