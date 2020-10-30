package com.example.leetCode;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int k = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    k += 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        k -= 2;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        k -= 2;
                    }
                }
            }
        }
        return k;
    }
}
