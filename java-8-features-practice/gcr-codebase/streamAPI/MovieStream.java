import java.util.*;

class Movie {
    String title;
    double rating;
    int year;

    Movie(String t, double r, int y) {
        title = t;
        rating = r;
        year = y;
    }
    @Override
    public String toString() {
        return title + " | Rating: " + rating + " | Year: " + year;
    }
}

public class MovieStream {

    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
                new Movie("A", 8.5, 2024),
                new Movie("B", 9.1, 2023),
                new Movie("C", 7.2, 2025),
                new Movie("D", 8.9, 2022),
                new Movie("E", 9.5, 2025),
                new Movie("F", 8.1, 2021),
                new Movie("G", 9.0, 2024)
        );

        System.out.println("Top 5 trending movies:");
        movies.stream()
                .filter(m -> m.rating > 8)   
                .sorted((m1, m2) -> Double.compare(m2.rating, m1.rating))
                .limit(5)
                .forEach(System.out::println);
    }
}