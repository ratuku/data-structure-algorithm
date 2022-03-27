package leetcode;

public class reverseNodesInKGroup_25 {

    public class ListNode { int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroupRecursion(ListNode head, int k) {

        int count = 0;
        ListNode ptr = head;


        // count first to the kth node
        while (count < k && ptr!=null) {

            ptr = ptr.next;

            count++;
        }

        if (count==k) {
            // reverse the first k-nodes
            ListNode reversedHead = this.reverseLinkedListRecursion(head, k);

            // now call the recursive call
            head.next = this.reverseKGroupRecursion(ptr, k);
            return reversedHead;
        }

        // return  head, no need to reverse k> length of this linkedlist sublist
        return head;


    }

    public ListNode reverseLinkedListRecursion(ListNode head, int k) {

        ListNode new_head = null;
        ListNode ptr = head;

        while (k > 0) {

            ListNode next_node = ptr.next;

            ptr.next = new_head;
            new_head = ptr;

            // move on to the next node. remeber we kept it innext_node
            ptr = next_node;

            // decrement
            k--;
        }

        return new_head;
    }
}
