package com.example.leetCode;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int firstZeroNumIndex = -1, firstNonZeroNumIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (firstZeroNumIndex == -1 && nums[i] == 0) {
                firstZeroNumIndex = i;
            }
            if (firstNonZeroNumIndex == -1 && nums[i] != 0) {
                firstNonZeroNumIndex = i;
            }
            if (firstZeroNumIndex != -1 && firstNonZeroNumIndex != -1) {
                break;
            }
        }

        if (firstNonZeroNumIndex == -1 || firstZeroNumIndex == -1) {
            return;
        }

        int arrayWalker = firstNonZeroNumIndex;
        while (arrayWalker < nums.length) {
            if (nums[arrayWalker] != 0 && firstZeroNumIndex < arrayWalker) {
                swap(nums, firstZeroNumIndex, arrayWalker);
                firstZeroNumIndex = findNextZeroNumIndexStartFrom(nums, firstZeroNumIndex + 1);
            }
            arrayWalker++;
        }
    }

    private int findNextZeroNumIndexStartFrom(int[] array, int startIndexInclusive) {
        for (int i = startIndexInclusive; i < array.length; i++) {
            if (array[i] == 0) {
                return i;
            }
        }
        throw new AssertionError("Unreachable code");
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
