package Heaps;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Max_Heap_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
        pqMax.add(10);
        pqMax.add(20);
        pqMax.add(30);
        pqMax.add(5);
        pqMax.add(15);
        pqMax.add(25);
        System.out.println("Max Element is: " + pqMax.peek());
        System.out.println("PriorityQueue: " + pqMax);
        System.out.println("Removing the Max element: "+ pqMax.poll());
        System.out.println("PriorityQueue: " + pqMax);
        System.out.println("Removing element at 3rd index: " + pqMax.remove(15));
        System.out.println("PriorityQueue: " + pqMax);
        System.out.println("Does the PriorityQueue contain 15? " + pqMax.contains(15));


    }
}



















