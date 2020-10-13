package com.example.leetCode;

public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        for (int i = (int) Math.ceil(Math.sqrt(area)); i > 0; i--) {
            int j = area / i;
            if (i * j != area) {
                continue;
            }
            ans[0] = j;
            ans[1] = i;
            break;
        }
        return ans;
    }
}
