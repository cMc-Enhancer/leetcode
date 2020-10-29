package com.example.leetCode;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int valueAbove) {
        if (root == null) {
            return 0;
        }

        valueAbove = valueAbove * 10 + root.val;
        if (root.left == null && root.right == null) {
            return valueAbove;
        }
        return dfs(root.left, valueAbove) + dfs(root.right, valueAbove);
    }

}
