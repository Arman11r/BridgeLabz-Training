// book class
class Book {

    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("book title: " + title);

        System.out.println("published year : " + publicationYear);
    }
}

// author class
class Author extends Book {

    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {


        super(title, publicationYear);
        this.name = name;

        this.bio = bio;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("author name: " + name);

        System.out.println("author bio: " + bio);
    }
}

public class LibraryDemo {
    public static void main(String[] args) {

        Author a1 =
                new Author("java basics", 2020,
                        "joe biden", "java  developer");

        a1.displayInfo();
    }
}