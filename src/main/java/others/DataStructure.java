package others;

import java.util.*;

public class DataStructure {

    public static void main (String...  args) {
        // array
        int size = 5;
        int [] array1 = new int[size];
        int [] array2 = {10,5,2,5};

        // Integer.MAX_VALUE; Integer.MIN_VALUE;

        // list
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.size();

        // Strings
        String string = "Jump no further";

        // StringbUILDER
        StringBuilder builder = new StringBuilder("Hello");
        builder.reverse();
        builder.append(3);
        System.out.println("bulder: " + builder);

        // Stack
        Stack<Integer> stack = new Stack();
        stack.push(3); // adds from the top
        stack.push(6);
        stack.push(9);
        stack.pop(); // removes from the top
        System.out.println("stack: " + stack.peek()); // returns object at the top without removing it


        // Queue
        Queue queue = new ArrayDeque();
        queue.offer("ok"); // adds rom the back. add()
        queue.offer("ok2");
        // queue.poll(); // from the front. remove()
        queue.peek(); // retrieves the head.in the front
        System.out.println("queue: " + queue.poll());

        for (Object item: queue) {

        }
        Queue queue2 = new LinkedList();
        queue2.offer("same");
        queue2.poll();
        Iterator iterator = queue2.iterator();
        while (iterator.hasNext()) {
            Object item = iterator.next();
        }

        // PriorityQueue: It provides O(log(n)) time for add and poll methods.
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> integerQue =  new PriorityQueue<>((o1, o2) -> {
            return o1*o1;
        });
        integerQue.add(4); // offer
        integerQue.add(9); // peek, front element in the priorityQueue
        // Iterator doesn't keep the order of the Queue..
        System.out.println(integerQue);

        // ArrayList
        ArrayList<String> list1 = new ArrayList<>();

        // LinkedList
        LinkedList<Integer> integers = new LinkedList<>();
        Collections.sort(integers);

        // Stack & Queue
        ArrayDeque arrayDeque = new ArrayDeque();

        // Set
        Set<Integer> set = new HashSet<>();
        set.add(54);

        // map
        HashMap<String, String> map = new HashMap<>();
        // More PriorityQueue
        /*PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a); // > 0 . b is greater.
        int[] stones = new int[]{2,7,4,1,8,1};

        for (int stone: stones) {
            heap.add(stone);
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }*/

        // CompareTo
        // compareTo(a,b) <0, a is less than 0 then b is greater. >0 then a is greater
        // priorityQueue has it in ascending order. so it starts off with low priority to highest priority.
        // hence if we want an integer in descending order (b -a). smallest int now has the highest priority hence will be shown later
        PriorityQueue<Node> pq = new PriorityQueue<Node>( new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                // compare n1 and n2
                return 0;
            }
        });

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>( new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return b - a;
            }
        });
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(10);
        System.out.println(priorityQueue.peek());

    }
}
