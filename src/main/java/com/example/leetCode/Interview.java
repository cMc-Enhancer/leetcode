package com.example.leetCode;

public class Interview {

    public int[] scoreRank(int[] ranked, int[] scores) {
        if (ranked == null || scores == null || scores.length == 0) {
            return new int[0];
        }

        int[] result = new int[scores.length];
        int[] totalScores = new int[scores.length];
        int totalScore = 0;
        for (int i = 0; i < scores.length; i++) {
            totalScore += scores[i];
            totalScores[i] = totalScore;
        }

        Integer[] uniqueRanked = new Integer[ranked.length];
        int index = 0;
        Integer last = null;
        for (int i : ranked) {
            if (last != null && i == last) {
                continue;
            }
            uniqueRanked[index++] = i;
            last = i;
        }

        int rank = index;
        for (int i = 0; i < totalScores.length; ) {
            if (rank <= 0 || uniqueRanked[rank - 1] > totalScores[i]) {
                result[i] = rank + 1;
                i++;
            } else if (uniqueRanked[rank - 1] == totalScores[i]) {
                result[i] = rank;
                i++;
            } else {
                rank--;
            }
        }

        return result;
    }

    public int[] printMatrixCounterClockwiseSpiral(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int[] result = new int[matrix.length * matrix[0].length];
        printHelper(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, result, 0);

        return result;
    }

    private void printHelper(int[][] matrix, int rowMin, int rowMax, int colMin, int colMax, int[] result, int currentIndex) {
        if (currentIndex >= result.length) {
            return;
        }

        for (int i = colMin; i <= colMax; i++) {
            result[currentIndex++] = matrix[rowMax][i];
        }

        for (int i = rowMax - 1; i >= rowMin; i--) {
            result[currentIndex++] = matrix[i][colMax];
        }

        for (int i = colMax - 1; i >= colMin; i--) {
            result[currentIndex++] = matrix[rowMin][i];
        }

        for (int i = rowMin + 1; i < rowMax; i++) {
            result[currentIndex++] = matrix[i][colMin];
        }

        printHelper(matrix, rowMin + 1, rowMax - 1, colMin + 1, colMax - 1, result, currentIndex);
    }


}
