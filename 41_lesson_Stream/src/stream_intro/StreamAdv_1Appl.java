package stream_intro;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamAdv_1Appl {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 3, -3, 3, 4, -5, 6, 4, -7, -7, -7, 8);

        //==============DISTINCT
        numbers.stream().distinct().forEach(System.out::println);
        System.out.println("==============");

        Set<Integer> set = new HashSet<>(numbers);
//        for (Integer integer : numbers) {
//            set.add(integer);
//        }
        System.out.println(set);

        System.out.println("=========LIMIT");
        IntStream.range(1, 100).limit(5).forEach(System.out::println);

        System.out.println("=========skip");
        IntStream.range(1, 100)
                .skip(95).forEach(System.out::println);

        System.out.println("=========Distinct + skip");
        Stream.of(1, 3, -3, 3, 4, -5, 6, 4, -7, -7, -7, 8)
                .distinct().skip(3)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("===================PEEK -посмотреть обработанный поток");
//        numbers.stream()
//                .peek(n-> System.out.println("in element "+ n))
//                .distinct()
//                .peek(n->System.out.println("after distinct element "+ n))
//                .forEach(System.out::println);
        numbers.stream()
                .peek(n-> System.out.println("in element "+ n))
                .filter(n -> n % 2 == 0)
                .peek(n->System.out.println("after filter element "+ n))
                .map(n -> n * n)
                .peek(n->System.out.println("after map element "+ n))
                .forEach(System.out::println);

        System.out.println("=============counter");
        int [] count = {0};
        int sum = IntStream.rangeClosed(0,5)
                .peek(n-> count[0]++)
                .sum();
        System.out.println("sum " + sum + " counter=  "+ count[0]);

        System.out.println("===========TakeWhile");

        List < Integer> numbers1 = List.of(1, 3, 3, 4, -3, -5, 6, 4, -7, -7, -7, 8);
        numbers1.stream()
                .takeWhile(x-> x> 0)
                .forEach(System.out::println);

        System.out.println("===========dropWhile");
        numbers1.stream()
                .dropWhile(x-> x>0)
                .forEach(System.out::println);







    }
}
