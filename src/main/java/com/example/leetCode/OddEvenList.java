package com.example.leetCode;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lastOdd = head, evenHead = head.next, lastEven = head.next;

        // Start from 3rd node
        boolean odd = true;
        for (ListNode current = lastEven.next; current != null; current = current.next) {
            if (odd) {
                lastOdd.next = current;
                lastOdd = current;
                odd = false;
            } else {
                lastEven.next = current;
                lastEven = current;
                odd = true;
            }
        }

        lastOdd.next = evenHead;
        lastEven.next = null;
        return head;
    }
}
