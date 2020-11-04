package com.example.leetCode;

public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        if (nums == null) {
            return -1;
        }

        int largest = 0, secondLargest = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[largest]) {
                secondLargest = largest;
                largest = i;
            } else if (secondLargest == -1 || nums[i] > nums[secondLargest]) {
                secondLargest = i;
            }
        }

        return nums.length == 1 || nums[largest] >= nums[secondLargest] * 2 ? largest : -1;
    }
}
