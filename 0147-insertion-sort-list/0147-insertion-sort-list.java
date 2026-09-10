class Solution {
    public ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode current = head;

        while (current != null) {

            // Save the next node
            ListNode next = current.next;

            // Find the position for current
            ListNode temp = dummy;

            while (temp.next != null && temp.next.val < current.val) {
                temp = temp.next;
            }

            // Insert current
            current.next = temp.next;
            temp.next = current;

            // Move to next input node
            current = next;
        }

        return dummy.next;
    }
}