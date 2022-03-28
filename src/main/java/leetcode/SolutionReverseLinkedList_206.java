package leetcode;

import java.util.HashMap;

public class SolutionReverseLinkedList_206 {

    public ListNode reverseList(ListNode head) {
        // lets try recursive

        if (head == null) {
            return null;
        }

        // filter
        ListNode itterator = head.next;
        head.next = null;

        while (itterator != null) {
            ListNode saveNextItterator = itterator.next;
            ListNode old_head = head;

            head = itterator;
            head.next = old_head;

            // itterator
            itterator = saveNextItterator;
        }

        return head;
    }

}

class ListNode { int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
