package com.example.leetCode;

public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode walker = dummyHead;

        while (walker.next != null && walker.next.next != null) {
            swapNextTwoNodes(walker);
            walker = walker.next.next;
        }
        return dummyHead.next;
    }

    private void swapNextTwoNodes(ListNode node) {
        ListNode next = node.next;
        ListNode nodeAfterAll = node.next.next.next;
        node.next = next.next;
        next.next = nodeAfterAll;
        node.next.next = next;
    }
}
