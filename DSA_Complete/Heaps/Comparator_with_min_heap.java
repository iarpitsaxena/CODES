package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Comparator_with_min_heap {
    static class Person{
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return(name + "(" + age + ")");
        }
    }

    public static void main(String[] args) {
        Comparator<Person> customComparator = Comparator.comparing((Person p) -> p.name).thenComparingInt((Person p)-> p.age);
        PriorityQueue<Person> pq = new PriorityQueue<>(customComparator);

        pq.add(new Person("Zara", 24));
        pq.add(new Person("Adil", 30));
        pq.add(new Person("Zara", 21));
        pq.add(new Person("Bilal", 28));
        pq.add(new Person("Adil", 22));

        System.out.println("Priority Queue (sorted by name then age):");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
