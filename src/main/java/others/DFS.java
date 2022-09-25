package others;

import java.util.Stack;

public class DFS {

    Stack<Node> nodes;

    public static void main(String[] args) {
        // create a binary tree

        Node head = new Node(10);
        head.left = new Node(5);
        head.right = new Node(15);

        // subtree left
        Node tree1 = head.left;
        tree1.left = new Node(2);
        tree1.right = new Node(7);

        // subtree right
        tree1 = head.right;
        tree1.left = new Node(13);
        tree1.right = new Node(20);

        DFS dfs = new DFS();
        dfs.search(head);
    }

    void search(Node node) {
        // base case
        // nodes = new Stack<>();
        //nodes.push(node);

        helper(node);
    }

    void helper(Node node) {
        visit(node);

        if (node!=null) {
            helper(node.right);
            helper(node.left);
        }
    }

    void visit(Node node) {
        if (node!=null) {
            System.out.println(node.val);
        }
    }
}
