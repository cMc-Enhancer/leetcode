package com.example.leetCode;

import java.util.Arrays;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || k > nums.length) {
            return new double[]{};
        }

        int windowCount = nums.length + 1 - k;
        boolean isEven = (k & 1) == 0;
        double[] result = new double[windowCount];
        int[] window = Arrays.copyOfRange(nums, 0, k);
        Arrays.sort(window);
        for (int i = 0; i < windowCount; i++) {
            result[i] = medianOfWindow(window, nums, i, k, isEven);
        }
        return result;
    }

    private double medianOfWindow(int[] window, int[] nums, int i, int k, boolean isEven) {
        if (i > 0) {
            reorderArray(window, nums[i - 1], nums[i - 1 + k]);
        }
        return isEven ? average(window[k / 2 - 1], window[k / 2]) : window[k / 2];
    }

    private double average(int i, int j) {
        return ((double) i) / 2 + ((double) j) / 2;
    }

    void reorderArray(int[] sortedArray, int removeValue, int addValue) {
        int removeIndex = Arrays.binarySearch(sortedArray, removeValue);
        if (removeIndex < 0) {
            int index = -1;
            for (int i = 0; i < sortedArray.length; i++) {
                if (sortedArray[i] == removeValue) {
                    index = i;
                }
            }
            System.out.println(index);
            throw new IllegalArgumentException("Cannot find target value " + removeValue + " to remove in array");
        }

        int indexOfSearchValue = Arrays.binarySearch(sortedArray, addValue);
        int addIndex;
        if (indexOfSearchValue == sortedArray.length) {
            addIndex = sortedArray.length - 1;
        } else if (indexOfSearchValue >= 0) {
            addIndex = indexOfSearchValue;
        } else {
            addIndex = -(indexOfSearchValue + 1);
        }

        if (removeIndex == addIndex || removeIndex == addIndex - 1) {
            sortedArray[removeIndex] = addValue;
        } else if (removeIndex < addIndex - 1) {
            System.arraycopy(sortedArray, removeIndex + 1, sortedArray, removeIndex, addIndex - removeIndex - 1);
            sortedArray[addIndex - 1] = addValue;
        } else if (removeIndex > addIndex) {
            System.arraycopy(sortedArray, addIndex, sortedArray, addIndex + 1, removeIndex - addIndex);
            sortedArray[addIndex] = addValue;
        }

//        if (sortedArray[removeIndex] > sortedArray[Math.min(removeIndex + 1, sortedArray.length - 1)]) {
//            throw new AssertionError("Remove breaks array order");
//        } else if (sortedArray[removeIndex] < sortedArray[Math.max(0, removeIndex - 1)]) {
//            throw new AssertionError("Remove breaks array order");
//        } else if (sortedArray[addIndex] > sortedArray[Math.min(addIndex + 1, sortedArray.length - 1)]) {
//            throw new AssertionError("Add breaks array order");
//        } else if (sortedArray[addIndex] < sortedArray[Math.max(0, addIndex - 1)]) {
//            throw new AssertionError("Add breaks array order");
//        }
    }
}
