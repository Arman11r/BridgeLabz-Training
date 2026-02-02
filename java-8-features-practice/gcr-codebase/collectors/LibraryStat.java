import java.util.*;
import java.util.stream.Collectors;

public class LibraryStat{

    static class Book {
        String genre;
        int pages;

        Book(String genre, int pages) {
            this.genre = genre;
            this.pages = pages;
        }
    }

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        books.add(new Book("SciFi", 300));
        books.add(new Book("SciFi", 250));
        books.add(new Book("Fantasy", 500));

        Map<String, IntSummaryStatistics> stats =
                books.stream()
                        .collect(Collectors.groupingBy(
                                b -> b.genre,
                                Collectors.summarizingInt(b -> b.pages)
                        ));

        for (String g : stats.keySet()) {
            IntSummaryStatistics s = stats.get(g);

            System.out.println("Genre: " + g);
            System.out.println("Total Pages: " + s.getSum());
            System.out.println("Average Pages: " + s.getAverage());
            System.out.println("Max Pages: " + s.getMax());
            System.out.println();
        }
    }
}