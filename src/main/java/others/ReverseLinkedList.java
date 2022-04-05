package others;

public class ReverseLinkedList {

    public NodeRight reverseRecursion(NodeRight node) {

        NodeRight tail = null;
        NodeRight curr = node;
        while (curr!=null) {
            // node ==2 -> 3. head==1. tail ==1.
            NodeRight nextNode = curr.right;
            curr.right = tail;
            tail = curr;

            curr = nextNode;
        }

        //

        // 1 -> 2                       -> 3

        // 2 -> 1;
        System.out.println(tail);
        return tail;
    }

    public static void main(String[] args) {

        NodeRight head = new NodeRight(10);
        head.right = new NodeRight(5);
        head.right.right = new NodeRight(15);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.reverseRecursion(head);
    }
}

class NodeRight {
    int val;

    NodeRight right;

    NodeRight (int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        NodeRight iterator = this;
        while(iterator!=null) {
            out.append(iterator.val + "->");
            iterator = iterator.right;
        }
        return out.toString();
    }
}
