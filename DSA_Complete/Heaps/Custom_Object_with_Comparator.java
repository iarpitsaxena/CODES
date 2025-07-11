package Heaps;

import java.util.PriorityQueue;
import java.util.Comparator;

public class Custom_Object_with_Comparator {
    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return (name + "(" + age + ")");
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Person> pq = new PriorityQueue<>(Comparator.comparingInt(p -> -p.age));
        pq.add(new Person("Alice", 30));
        pq.add(new Person("Bob", 25));
        pq.add(new Person("Charlie", 35));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
