package com.example.leetCode;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode reversedHead = reverse(mid);
        crossReorder(head, reversedHead);
    }

    /**
     * 1. Count <= 1, return head
     * 2. Count == odd, return mid
     * 3. Count == even, return (count/2 + 1)th
     */
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private void crossReorder(ListNode leftHead, ListNode rightHead) {
        ListNode leftCurrent = leftHead, rightCurrent = rightHead;
        while (leftCurrent != null) {
            ListNode leftNext = leftCurrent.next;
            leftCurrent.next = rightCurrent;

            if (rightCurrent != null) {
                ListNode rightNext = rightCurrent.next;
                rightCurrent.next = leftNext;
                rightCurrent = rightNext;
            }

            leftCurrent = leftNext;
        }
    }
}
