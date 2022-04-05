package others;

import javax.print.attribute.standard.NumberUp;

public class BinaryTreeTraversal {

    void inOrderTraversal(Node node) {
        if (node!=null) {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    void preOrderTraversal(Node node) {
        if (node!= null) {
            visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    void postOrderTraversal(Node node) {
        if (node!=null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            visit(node);
        }
    }

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

        BinaryTreeTraversal traversal = new BinaryTreeTraversal();
        traversal.postOrderTraversal(head);
    }

    void visit(Node node){
        System.out.println(node.val) ;
    }
}

class Node {
    int val;

    Node right;
    Node left;

    Node (int val) {
        this.val = val;
    }
}
