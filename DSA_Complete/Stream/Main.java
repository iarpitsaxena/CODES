package Stream;

import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        Stream<String> newStream =
                Stream.generate(()->"Hey!, Stream this side").limit(10).forEach(System.out::println);
//        System.out.println(newStream);


    }

}