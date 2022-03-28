package leetcode;

import java.util.HashMap;

public class SolutionCopyRandomList_138 {

    class Node extends Object {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    class Solution {
        public Node copyRandomList(Node head) {

            // copy
            Node deepCopy = new Node(0);
            // original loop node itterator
            Node nodeIterator = head;
            Node deepCopyIterator = deepCopy;
            // Store references to new nodes. To be used later by the random property
            // jey old nodes hash code will be key, and value will be reference to the new node
            HashMap<Integer, Node> hashMapOldNodesToNew = new HashMap<>();

            // first loop copy links, without updating the random property
            while (nodeIterator!=null) {
                deepCopyIterator.next = new Node(nodeIterator.val);
                deepCopyIterator = deepCopyIterator.next;
                // save the nodes in a map
                // did some other variable need us
                hashMapOldNodesToNew.put(nodeIterator.hashCode(), deepCopyIterator);
                nodeIterator = nodeIterator.next;
            }

            // copy update the random property
            nodeIterator = head;
            deepCopyIterator = deepCopy.next;
            while (nodeIterator!=null) {

                if (nodeIterator.random == null) {
                    deepCopyIterator.random = null;
                }
                else {
                    deepCopyIterator.random = (Node) hashMapOldNodesToNew.get(nodeIterator.random.hashCode());
                }

                nodeIterator = nodeIterator.next;
                deepCopyIterator = deepCopyIterator.next;
            }


            return deepCopy.next;
        }
    }
}
