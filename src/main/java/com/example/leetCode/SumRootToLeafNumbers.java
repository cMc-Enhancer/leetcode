package com.example.leetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        List<Deque<Integer>> rootToLeafNumbers = getRootToLeafNumbers(root);
        for (Deque<Integer> number : rootToLeafNumbers) {
            result += rootToLeafNumberToInt(number);
        }
        return result;
    }

    private List<Deque<Integer>> getRootToLeafNumbers(TreeNode root) {
        List<Deque<Integer>> rootToLeafNumbers = new LinkedList<>();
        if (root.left != null) {
            List<Deque<Integer>> leftNumbers = getRootToLeafNumbers(root.left);
            for (Deque<Integer> numbers : leftNumbers) {
                numbers.addFirst(root.val);
            }
            rootToLeafNumbers.addAll(leftNumbers);
        }

        if (root.right != null) {
            List<Deque<Integer>> rightNumbers = getRootToLeafNumbers(root.right);
            for (Deque<Integer> numbers : rightNumbers) {
                numbers.addFirst(root.val);
            }
            rootToLeafNumbers.addAll(rightNumbers);
        }

        if (root.left == null || root.right == null) {
            Deque<Integer> rootToLeafNumber = new LinkedList<>();
            rootToLeafNumber.addFirst(root.val);
            rootToLeafNumbers.add(rootToLeafNumber);
        }

        return rootToLeafNumbers;
    }

    private int rootToLeafNumberToInt(Deque<Integer> rootToLeafNumber) {
        if (rootToLeafNumber.isEmpty()) {
            return 0;
        }

        int value = 0, multiplier = 1;
        while (!rootToLeafNumber.isEmpty()) {
            value += rootToLeafNumber.removeLast() * multiplier;
            multiplier *= 10;
        }

        return value;
    }
}
