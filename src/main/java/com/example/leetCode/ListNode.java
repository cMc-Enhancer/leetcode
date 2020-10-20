package com.example.leetCode;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode arrayToList(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        for (int i : array) {
            ListNode newNode = new ListNode(i);
            prev.next = newNode;
            prev = newNode;
        }
        return dummy.next;
    }

    public static Integer[] listToArray(ListNode head) {
        if (head == null) {
            return new Integer[]{};
        }

        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        return list.toArray(new Integer[]{});
    }
}
