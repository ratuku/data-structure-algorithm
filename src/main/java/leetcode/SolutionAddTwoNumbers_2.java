package leetcode;

import java.util.Stack;

public class SolutionAddTwoNumbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode suml = new ListNode();
        int overflow = 0;
        int l1_value = 0;
        int l2_value = 0;
        int sum;

        while (l1!=null && l2!=null) {
            if (l1==null) {
                l1_value = 0;
            }
            else {
                l1_value = l1.val;
            }
            if (l2!=null) {
                l2_value = l2.val;
            }
            else {
                l2_value = l2.val;
            }
            sum = l1_value + l2_value + overflow;
            suml.val = sum%10;
            overflow = sum/10;
            suml.next = new ListNode();
            suml = suml.next;
            System.out.println("sum: " + Integer.toString(suml.val) + " ");
            if(l1!=null) {
                l1 = l1.next;
            }
            if (l2!=null) {
                l2 = l2.next;
            }
        }

        return null;
    }

     public class ListNode { int val;
      ListNode next;
      ListNode() {};
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {

  }


}
