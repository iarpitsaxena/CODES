package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
public class collect {
//    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//
//        // Collecting to a List
//        List<Integer> evenNumbers = numbers.stream()
//                .filter(n -> n % 2 == 0)
//                .Streams.collect(Collectors.toList());
//        System.out.println("Even numbers: " + evenNumbers);
//
//        // Collecting to a Set
//        Set<Integer> uniqueEvenNumbers = numbers.stream()
//                .filter(n -> n % 2 == 0)
//                .Streams.collect(Collectors.toSet());
//        System.out.println("Unique even numbers: " + uniqueEvenNumbers);
//
//        // Collecting to a Map
//        Map<Integer, String> numberToName = numbers.stream()
//                .filter(n -> n % 2 == 0)
//                .Streams.collect(Collectors.toMap(n -> n, n -> "Number " + n));
//    }
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1,345,6,765,2525,6252,6674,21,253,24,56,78,90,23);
    List<Integer> evenNumbers = numbers.stream()
            .filter(n->n%2==0)
            .collect(Collectors.toList());
    System.out.println(evenNumbers);

    AtomicInteger keyCount = new AtomicInteger(1 );
    Map<Integer, String> numtoName = numbers.stream()
            .filter(n->n%2 == 0)
            .collect(Collectors.toMap(n->keyCount.getAndIncrement(),n->" Number "+n));
    System.out.println(numtoName);
}
}
