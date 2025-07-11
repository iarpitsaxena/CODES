package Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Comparator_Example {
    static class Person{
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString(){
            return(name + "(" + age + ")");
        }

        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Zara", 24));
        people.add(new Person("Adil", 30));
        people.add(new Person("Zara", 21));
        people.add(new Person("Bilal", 28));
        people.add(new Person("Adil", 22));

        //sort by name(ascending)
        people.sort(Comparator.comparing(person-> person.name));
        System.out.println("Sorted by name(ascending):");
        for(Person p : people){
            System.out.println(p);
        }

        // Sort by name (descending)
        people.sort(Comparator.comparing((Person p)-> p.name).reversed());
        System.out.println("Sorted by name (descending):");
        for (Person p : people) {
            System.out.println(p);
        }


        //sort by age(ascending)
        people.sort(Comparator.comparingInt(person -> person.age));
        System.out.println("Sorted by age(ascending):");
        for(Person p : people){
            System.out.println(p);
        }

        // sort by name then age (ascending)
        people.sort(
                Comparator.comparing(Person::getName)
                        .thenComparing(Person::getAge)
        );
        System.out.println("Sorted by name then age (ascending) with getters:");
        for(Person p : people){
            System.out.println(p);
        }

        people.sort(Comparator.comparing((Person p) -> p.name)
                .thenComparingInt(p -> p.age));


        System.out.println("Sorted by name then age (ascending):");
        for (Person p : people) {
            System.out.println(p);
        }
    }
}
