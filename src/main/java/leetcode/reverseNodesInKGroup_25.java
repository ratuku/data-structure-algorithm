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

    public ListNode reverseLinkedList(ListNode head, int k) {

        ListNode new_head = null;

        ListNode ptr = head;

        while (k>0) {
            ListNode next_node = ptr.next;


            ptr.next = new_head;
            new_head = ptr;

            // move to the next node
            ptr = next_node;


            k--;
        }

        return new_head;

    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode ktail = null;
        ListNode ptr = head;

        // return new_head
        ListNode new_head = null;

        // loop over ptr...
        while (ptr!=null) {

            int count = 0;

            // start counting nodes from the head
            ptr = head;

            // find the head of the next k nodes
            while (count < k && ptr !=null ) {
                ptr = ptr.next;
                count ++;
            }

            // if we counted k nodes, reverse them,
            if (count==k) {

                // reverse
                ListNode revHead = reverseLinkedList(head, k);

                // if newhead is null
                if (new_head == null) new_head = revHead;

                // ktail is the tail of the previous block
                if (ktail !=null) ktail.next = revHead;

                ktail =  head;
                head = ptr;
            }


        }

        // attach the final, possibly un-reversed portion
        if (ktail!=null) ktail.next = head;

        return new_head == null ? head : new_head;

    }
}
