
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Handle empty list or single node
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find the length and the last node
        ListNode tail = head;
        int length = 1;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Reduce unnecessary rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Connect the tail to the head to form a circle
        tail.next = head;

        // Find the new tail: length - k - 1 steps from head
        int stepsToNewTail = length - k - 1;
        ListNode newTail = head;

        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
