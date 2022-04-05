package others;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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

        BFS bfs = new BFS();
        bfs.search(head);
    }

    void search (Node root) {
        Queue<Node>  queue = new LinkedList<>();
        root.marked = true;
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node r = queue.poll();
            visit(r);
            // loop through adjacent nodes
            if (r.right!=null && !r.right.marked) {
                r.right.marked = true;
                queue.offer(r.right);
            }
            if (r.left!=null && !r.left.marked) {
                r.left.marked = true;
                queue.offer(r.left);
            }
        }
    }

    void visit(Node node){
        if (node!=null) {
            System.out.println(node.val);
        }
    }
}
