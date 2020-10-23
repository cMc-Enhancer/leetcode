package com.example.leetCode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        ListNode reversedHead = reverse(mid);
        while (reversedHead != null) {
            if (reversedHead.val != head.val) {
                return false;
            }
            reversedHead = reversedHead.next;
            head = head.next;
        }

        return true;
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
}
