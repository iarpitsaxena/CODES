package Heaps;

import java.util.PriorityQueue;

public class Custom_Object_with_Comparable {
    static class Person implements Comparable<Person>{
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person other){
            return Integer.compare(this.age, other.age);
        }

        @Override
        public String toString(){
            return(name + "(" + age + ")");
        }
    }


    public static void main(String[] args) {
        PriorityQueue<Person> pq = new PriorityQueue<>();
        pq.add(new Person("Adil", 32));
        pq.add(new Person("Zeeshan", 25));
        pq.add(new Person("Ali", 28));
        pq.add(new Person("Ahmed", 30));
        pq.add(new Person("Bilal", 22));

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }

}
