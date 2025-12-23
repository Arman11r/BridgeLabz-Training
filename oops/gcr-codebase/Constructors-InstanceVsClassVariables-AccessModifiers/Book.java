class Book {

    // storing book title
    String title;

    // storing author name
    String author;

    // storing book price
    double price;

    // default constructor
    Book() {
        // setting default values
        title = "unknown";
        author = "unknown";
        price = 0;
    }

    // parameterized constructor
    Book(String title, String author, double price) {
        // assigning values using this
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // method to show book details
    void displayBook() {
        System.out.println(title + " by " + author + " price " + price);
    }

    public static void main(String[] args) {

        // creating book using default constructor
        Book b1 = new Book();

        // creating book using parameter constructor
        Book b2 = new Book("2States", "Chetan Bhagat", 500);

        // displaying both books
        b1.displayBook();
        b2.displayBook();
    }
}