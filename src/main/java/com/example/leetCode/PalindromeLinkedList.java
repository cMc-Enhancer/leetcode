package com.example.leetCode;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode mid = findMidLeft(head);
        ListNode reversedHead = reverse(mid.next);
        ListNode tmp = reversedHead;
        while (tmp != null) {
            if (tmp.val != head.val) {
                return false;
            }
            tmp = tmp.next;
            head = head.next;
        }

        mid.next = reverse(reversedHead);

        return true;
    }

    /**
     * 1. Count <= 1, return head
     * 2. Count == odd, return mid
     * 3. Count == even, return (count/2)th
     */
    private ListNode findMidLeft(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
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
}
