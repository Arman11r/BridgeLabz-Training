class LibraryBook {

    // book title
    String title;

    // author name
    String author;

    // price of book
    double price;

    // availability status
    boolean available;

    // constructor
    LibraryBook(String title, String author, double price) {
        // assigning values
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    // method to borrow book
    void borrowBook() {

        // checking availability
        if (available) {
            available = false;
            System.out.println("Book borrowed");
        } else {
            System.out.println("Book not available");
        }
    }

    public static void main(String[] args) {

        // creating library book
        LibraryBook b = new LibraryBook("Java", "James", 400);

        // borrowing book twice
        b.borrowBook();
        b.borrowBook();
    }
}