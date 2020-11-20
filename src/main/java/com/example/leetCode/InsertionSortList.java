package com.example.leetCode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode sortedListHead = null;
        while (head != null) {
            ListNode next = head.next;
            sortedListHead = insert(sortedListHead, head);
            head = next;
        }
        return sortedListHead;
    }

    private ListNode insert(ListNode sortedListHead, ListNode nodeToInsert) {
        if (sortedListHead == null || nodeToInsert.val < sortedListHead.val) {
            nodeToInsert.next = sortedListHead;
            return nodeToInsert;
        }

        for (ListNode sortedListNode = sortedListHead; sortedListNode != null; sortedListNode = sortedListNode.next) {
            ListNode next = sortedListNode.next;
            if (nodeToInsert.val >= sortedListNode.val && (next == null || nodeToInsert.val <= next.val)) {
                sortedListNode.next = nodeToInsert;
                nodeToInsert.next = next;
                return sortedListHead;
            }
        }
        throw new AssertionError("Unreachable code");
    }
}
