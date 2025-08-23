package stream_intro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieAppl {
    public static void main(String[] args) {

        Movie[]movies = {
                new Movie("movie1", 2017, 4.5),
                new Movie("movie2", 2010, 4.1),
                new Movie("movie3", 2019, 4.8),
                new Movie("movie4", 2015, 3.5),
                new Movie("movie5", 2018, 5.5),
                new Movie("movie6", 2018, 4.5),
                new Movie("movie7", 2019, 4.8),

        };
        displayMovieTitle(movies, 2019, 4.8);
    }

    private static void displayMovieTitle(Movie[] movies, int year, double raiting) {
        List<Movie> list = new ArrayList<>();
        for (Movie movie : movies) {
            if(movie.getYear() == year && movie.getRating() == raiting)
                list.add(movie);
        }
        list.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                int res = Double.compare(o1. getRating(), o2.getRating());
                return res == 0 ? o1.getTitle().compareTo(o2.getTitle()) : res;

            }
        });
        for (Movie movie : list) {
            System.out.println(movie.getTitle());

        }
    }
}
