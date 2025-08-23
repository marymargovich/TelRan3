package stream_intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class StreamAdvAppl {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, -3, 3, 4, -5, 6, - 7);
        numbers.stream().filter(n-> n> 0 && n % 2 ==0).forEach(System.out::println);
        System.out.println("================================");
        for (Integer number : numbers) {
            if (number > 0 && number % 2 == 0) System.out.println(number);
            System.out.println("================================");
            IntStream.of(1, -3, 3, 4, -5, 6, -7).sorted().forEach(System.out::println);

            System.out.println("================================");
            //IntStream.of(1, -3, 3, 4, -5, 6, -7).boxed().sorted(Comparator.reverseOrder().mapToInt(Integer::intValue).forEach(System.out::println));





            Movie[] movies = {
                    new Movie("movie1", 2017, 4.5),
                    new Movie("movie2", 2010, 4.1),
                    new Movie("movie3", 2019, 4.5),
                    new Movie("movie4", 2015, 3.5),
                    new Movie("movie5", 2018, 5.5),
                    new Movie("movie6", 2018, 4.5),
                    new Movie("movie7", 2019, 4.8)};

            List<Movie> m1 = List.of(movies);
            displayMovieTitle(movies, 2019, 4.8);
            System.out.println("++++++++++++");
            displayMovieTitleStream(movies,2018, 4.8);

           // m1.stream().map(movie -> movie.getTitle()).forEach(System.out::println);


        }
    }
        private static void displayMovieTitle(Movie[] movies, int year, double rating) {
            List<Movie> list = new ArrayList<>();
            for (Movie m : movies) {
                if (m.getYear() == year && m.getRating() == rating)
                    list.add(m);
            }
            list.sort(new Comparator<Movie>() {

                @Override
                public int compare(Movie o1, Movie o2) {
                    int res= Double.compare(o1.getRating(),o2.getRating());
                    return res==0? o1.getTitle().compareTo(o2.getTitle()): res;
                }
            });
            for (Movie m : list) {
                System.out.println(m.getTitle());
            }
        }

    private static void displayMovieTitleStream(Movie[] movies, int year, double rating){
        Arrays.stream(movies)
                .filter(m->m.getYear() >= year && m.getRating() == rating)
                .sorted(Comparator.comparingDouble((Movie m) -> m.getRating())
                        .reversed().thenComparingInt(m ->m.getYear()))
                .map(n -> n.getTitle()).forEach(System.out::println);

        }

    }
    /*
    	private static void displayMovieTitleStream(Movie[] movies, int year, double rating) {
		Arrays.stream(movies)
		.filter(m->m.getYear() >= year && m.getRating() >= rating)
//		.sorted(Comparator.comparingDouble((Movie m)->m.getRating())
		.sorted(Comparator.comparingDouble(Movie::getRating)
				.reversed()
				//.thenComparingInt(m->m.getYear()))
				.thenComparingInt(Movie::getYear))
//				.map(n->n.getTitle())
		.map(Movie::getTitle)
		.forEach(System.out::println);
	}
     */

