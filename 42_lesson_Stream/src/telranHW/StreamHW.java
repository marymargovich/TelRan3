package telranHW;

import java.util.*;
import java.util.stream.*;

public class StreamHW {

    public static void main(String[] args) {

        System.out.println("===========TASK 1===========");
        ArrayList<String> names = new ArrayList<>
                (Arrays.asList(" alice ", "BOB", null, " Eve "));


        List<String> res1 = names.stream()
                .filter(s-> s != null)
                .map(s -> s.trim())
                .map(s -> s.substring(0,1).toUpperCase()
                        + s.substring(1).toLowerCase())
                        .toList();
        System.out.println(res1);



        System.out.println("==========Task1 references");

        names.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .map(s -> s.substring(0,1).toUpperCase()
                        + s.substring(1).toLowerCase())
                .forEach(System.out::println);

        System.out.println("===========TASK 2===========");
        List<String> xs = List.of("10"," -3 ","x","42");

        int sum = xs.stream()
                .map(s-> s.trim())
                .filter(s -> s.matches("-?\\d+"))
                .mapToInt(s -> Integer.parseInt(s))
                .sum();
        System.out.println(sum);
        System.out.println("=======T2_references ");

        sum = xs.stream()
                .map(s-> s.trim())
                .filter(s -> s.matches("-?\\d+"))
                .mapToInt(Integer:: parseInt)
                .sum();
        System.out.println(sum);



        System.out.println("===========TASK 3===========");

        List<String> titles = List.of("java", "Zebra", "apple");

        titles.stream()
                .sorted((s1,s2)-> s1.toLowerCase().compareTo(s2.toLowerCase()))
                .forEach(System.out::println);

        System.out.println("=======Task3 references");

        titles.stream()
                .sorted(Comparator.comparing(String::toLowerCase))
                .forEach(System.out::println);

        System.out.println("===========TASK 4");

        String input = "lorem ipsum dolor sit amet amet";
        Map<Integer, Long> result = Arrays.stream(input.split("\\s+"))
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        System.out.println(result);

        System.out.println("===========TASK 5");

        List<String> sentences = List.of("Hello world", "world of Streams", "HELLO lambda");
        String[] unique = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .map(String:: toLowerCase)
                .distinct()
                .sorted()
                .toArray(String[]:: new);
        System.out.println(Arrays.toString(unique));

        System.out.println("===========TASK 6");

        IntStream.range(1, 1000)
                .filter(StreamHW::isPrime)
                .limit(10)
                .forEach(n-> System.out.print(n+ " "));




    }
    static boolean isPrime(int n){
        if (n==1) return false;
        for (int i = 2; i< n; i++) {
            if( n % i== 0)
                return false;
        }
        return true;
    }
}
