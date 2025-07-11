package Heaps;

import java.util.PriorityQueue;

public class Min_Heap_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(5);
        pq.add(15);
        pq.add(30);
        pq.add(25);
        System.out.println("Priority Queue: " + pq);
        System.out.println("Minimum Element: " + pq.peek() );
        System.out.println("Removing Minimum Element: " + pq.poll());
        System.out.println("Priority Queue after removal: " + pq);
    }
}
