package com.example.leetCode;

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }

        int top = -1;
        int last = A[0];
        for (int i = 1; i < A.length; i++) {
            int current = A[i];
            if (current == last) {
                return false;
            } else if (top > 0 && current > last) {
                return false;
            } else if (top == -1 && current < last) {
                if (i == 1) {
                    return false;
                } else {
                    top = i - 1;
                }
            }

            last = current;
        }

        return top != -1;
    }
}
