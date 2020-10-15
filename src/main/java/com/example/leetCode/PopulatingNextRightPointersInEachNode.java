package com.example.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        Queue<Node> nextLevelQueue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                nextLevelQueue.offer(node.left);
            }
            if (node.right != null) {
                nextLevelQueue.offer(node.right);
            }

            if (!queue.isEmpty()) {
                node.next = queue.peek();
            } else {
                queue = nextLevelQueue;
                nextLevelQueue = new LinkedList<>();
            }
        }
        return root;
    }
}
