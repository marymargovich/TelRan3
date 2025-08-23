package stream_intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAppl {
    public static void main(String[] args) {
        Movie[] movies = {
                new Movie("movie1", 2017, 4.5),
                new Movie("movie2", 2010, 4.1),
                new Movie("movie3", 2019, 4.8),
                new Movie("movie4", 2015, 3.5),
                new Movie("movie5", 2018, 5.5),
                new Movie("movie6", 2018, 4.5),
                new Movie("movie7", 2019, 4.8),
        };
        //===========COLLECTIONS
        List<Movie> list = new ArrayList<>(Arrays.asList(movies));
        Stream<Movie> stream1 = list.stream();

        //==================ARRAY
        Stream<Movie> stream2 = Arrays.stream(movies);

        //============VALUES
        Stream<String> streamStr = Stream.of("a", "b", "c");
        Stream<Integer> streamInt = Stream.of(1,2,3,4,5);

        //============STRING
        IntStream streamFromString = "123fkkfkf".chars();

        //==============Builder
        Stream.builder().add("a").add("b").add("c").build();

        //====================================
        IntStream.iterate(1, x -> x * 2).limit(10). forEach(System.out::println);

        int x = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println(x);
            x *=2;
        }
        Stream.generate(()-> "hello Karmiel").limit(10).forEach(System.out::println);
        Stream.generate(()-> "hello Karmiel").limit(10).forEach(s1 -> System.out.println(s1));





    }

}

