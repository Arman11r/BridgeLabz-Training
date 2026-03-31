

class Book {

    // library name same for all
    private static String libraryName;

    // book title
    private String title;

    // book author
    private String author;

    // isbn should not change
    private final String isbn;

    // constructor for book
    public Book(String title, String author, String isbn) {

        // using this keyword
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // setting library name
    public static void setLibraryName(String name) {
        libraryName = name;
    }

    // displaying library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // displaying book info
    public void displayBookDetails() {

        // checking instance before print
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }
}

public class Library {

    public static void main(String[] args) {

        // setting library name
        Book.setLibraryName("Egmore Library");

        // showing library name
        Book.displayLibraryName();

        // creating book
        Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");

        // displaying book
        book1.displayBookDetails();
    }
}