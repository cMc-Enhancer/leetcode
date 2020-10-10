package com.example.leetCode;

import lombok.Data;

import java.util.Arrays;
import java.util.Random;

public class Skiplist {

    private static final double COIN_FLIP_FACTOR = 0.5;

    private static final int MAX_LEVEL = 4;

    private final Random random;

    private SkiplistNode head;

    private SkiplistNode[] searchStatus;

    public Skiplist() {
        random = new Random();
        searchStatus = new SkiplistNode[MAX_LEVEL];
    }

    public boolean search(int target) {
        initSearchStatus();

        if (target < head.getValue()) {
            for (int i = 0; i < MAX_LEVEL; i++) {
                Arrays.fill(searchStatus, null);
            }
            return false;
        }

        SkiplistNode currentNode = head;
        int level = MAX_LEVEL - 1;
        while (true) {
            currentNode = findInCurrentLevel(currentNode, target);
            if (currentNode == null) {
                return false;
            }

            searchStatus[level] = currentNode;

            if (currentNode.hasLowerLevelNode()) {
                currentNode = currentNode.getLowerLevelNode();
                level--;
            } else {
                return currentNode.getValue() == target;
            }
        }
    }

    public void add(int num) {
        SkiplistNode newNode = new SkiplistNode(0, num);
        SkiplistNode lower = null;

        if (head == null) {
            init(newNode);
        }

        search(num);

        int level = 0;
        boolean addOnHigherLevel = true;
        while (level < MAX_LEVEL && addOnHigherLevel) {
            SkiplistNode addedNode = addNodeInLevel(searchStatus[level], newNode);
            addedNode.setLowerLevelNode(lower);
            lower = addedNode;
            level++;
            addOnHigherLevel = flipCoin();
        }
    }

    public boolean erase(int num) {
        if (!search(num)) {
            return false;
        }
        return false;
    }

    private void init(SkiplistNode node) {
        int value = node.getValue();
        SkiplistNode lastNode = node;
        for (int i = 1; i < MAX_LEVEL; i++) {
            node = new SkiplistNode(i, value);
            node.setLowerLevelNode(lastNode);
            lastNode = node;
        }
        head = lastNode;
    }

    private void initSearchStatus() {
        SkiplistNode node = head;
        for (int level = MAX_LEVEL - 1; level >= 0; level--) {
            searchStatus[level] = node;
            node = node.getLowerLevelNode();
        }
    }

    private void addOnHead(SkiplistNode node) {
        SkiplistNode upperLevelNode = null;
        SkiplistNode newHead = node;
        for (SkiplistNode h = head; h.hasLowerLevelNode(); h = h.getLowerLevelNode()) {
            node = SkiplistNode.createFrom(node);
            h.setPrev(node);
            node.setNext(head);
            node.setNext(h);
            if (upperLevelNode != null) {
                upperLevelNode.setLowerLevelNode(node);
            }
            upperLevelNode = node;
        }
        head = newHead;
    }

    private SkiplistNode addNodeInLevel(SkiplistNode prevNode, SkiplistNode newNode) {
        SkiplistNode next = prevNode.getNext();
        newNode.setNext(next);
        prevNode.setNext(newNode);
        newNode.setPrev(prevNode);
        if (next != null) {
            next.setPrev(newNode);
        }
        return newNode;
    }

    private boolean flipCoin() {
        return random.nextDouble() < COIN_FLIP_FACTOR;
    }

    private SkiplistNode findInCurrentLevel(SkiplistNode node, int target) {
        SkiplistNode last = null, current = node;
        while (current != null) {
            int currentValue = current.getValue();
            if (target == currentValue) {
                return current;
            } else if (target < currentValue) {
                return last;
            } else {
                last = current;
                current = current.getNext();
            }
        }
        return last;
    }

    @Data
    private static class SkiplistNode {

        private SkiplistNode prev;

        private SkiplistNode next;

        private SkiplistNode lowerLevelNode;

        private int level;

        private int value;

        private static SkiplistNode createFrom(SkiplistNode node) {
            return new SkiplistNode(node.getLevel(), node.getValue());
        }

        private SkiplistNode(int level, int value) {
            this.level = level;
            this.value = value;
        }

        private boolean hasLowerLevelNode() {
            return level > 0;
        }

    }
}
