package com.example.leetCode;

public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }

        for (int[] row : A) {
            if (row[0] == 0) {
                flipRow(row);
            }
        }

        for (int i = 0; i < A[0].length; i++) {
            flipColumnIfMoreZeroThanOne(A, i);
        }

        return calculateScore(A);
    }

    private void flipRow(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = row[i] == 1 ? 0 : 1;
        }
    }

    private void flipColumnIfMoreZeroThanOne(int[][] matrix, int columnIndex) {
        int countOfZero = 0;

        for (int[] row : matrix) {
            if (row[columnIndex] == 0) {
                countOfZero++;
            }
        }

        if (countOfZero > matrix.length - countOfZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][columnIndex] = matrix[i][columnIndex] == 1 ? 0 : 1;
            }
        }
    }

    private int calculateScore(int[][] matrix) {
        int score = 0;
        for (int[] row : matrix) {
            score += scoreOfRow(row);
        }
        return score;
    }

    private int scoreOfRow(int[] row) {
        int score = 0;
        int value = 1;
        for (int i = row.length - 1; i >= 0; i--) {
            if (row[i] == 1) {
                score += value;
            }
            value <<= 1;
        }
        return score;
    }
}
