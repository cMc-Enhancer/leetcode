package com.example.leetCode;

import java.util.Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }

        boolean[] nums = new boolean[n + 1];
        Arrays.fill(nums, 2, n, true);

        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i; i * j <= n; j++) {
                nums[i * j] = false;
            }
        }

        int count = 0;
        for (boolean isPrime : nums) {
            if (isPrime) {
                count++;
            }
        }

        return count;
    }
}
