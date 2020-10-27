package com.example.leetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        TreeNode current = root;
        Deque<TreeNode> deque = new LinkedList<>();
        while (current != null) {
            result.add(current.val);
            if (current.right != null) {
                deque.push(current.right);
            }
            if (current.left != null) {
                current = current.left;
            } else {
                current = deque.poll();
            }
        }

        return result;
    }
}
