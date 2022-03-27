package leetcode;

public class SolutionMerge2NonDecreasingLinkedList_21 {

    public ListNode mergeTwoListsMyIncompleteSolution(ListNode list1, ListNode list2) {

        ListNode mergedList = new ListNode(0);
        ListNode currentMergedNode = mergedList;

        boolean dontGoNexTl1 = false;
        boolean dontGoNexTl2 = false;

        while (list1!=null || list2!=null) {


            // Handle nulls
            if (list1==null) {
                currentMergedNode.next = new ListNode(list2.val);
                currentMergedNode = currentMergedNode.next;
                list2 = list2.next;
                continue;
            }
            if (list2==null) {
                currentMergedNode.next = new ListNode(list1.val);
                currentMergedNode = currentMergedNode.next;
                list1 = list1.next;
                continue;
            }

            // main logic
            if (list1.val<=list2.val) {
                if (list1.next== null || (list1.next.val>list2.val) ) {
                    currentMergedNode.next = new ListNode(list1.val, new ListNode(list2.val));
                    dontGoNexTl2 = false;
                }
                else {
                    currentMergedNode.next = new ListNode(list1.val, new ListNode(list1.next.val));
                    // dont increment lsit 1
                    dontGoNexTl2 = true;
                    list1 = list1.next;
                }
                currentMergedNode = currentMergedNode.next.next;
            }
            else {
                if (list2.next== null || (list2.next.val>list1.val) ) {
                    currentMergedNode.next = new ListNode(list2.val, new ListNode(list1.val));
                    dontGoNexTl1 = false;
                }
                else {
                    currentMergedNode.next = new ListNode(list2.val, new ListNode(list2.next.val));
                    // dont increment lsit 2
                    dontGoNexTl1 = true;
                    list2 = list2.next;
                }
                currentMergedNode = currentMergedNode.next.next;
            }

            // increment the listNodes
            if (list1!=null && !dontGoNexTl1) {
                list1 = list1.next;
                dontGoNexTl1 = false;
            }
            if (list2!=null && !dontGoNexTl2) {
                list2 = list2.next;
                dontGoNexTl1 = false;
            }

        }

        return mergedList.next;


    }

    public ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        // base case
        if  (list1 == null) return list2;
        if (list2 == null) return list1;

        // recursion..  compare the two heads
        ListNode headnode;


        if(list1.val<list2.val) {
            headnode = list1;
            list1 = list1.next;
        }
        else {
            headnode = list2;
            list2 = list2.next;
        }

        // call the next recursion call

        headnode.next = mergeTwoListsRecursion(list1, list2);

        // a return statement
        return headnode;

    }


    public class ListNode { int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
