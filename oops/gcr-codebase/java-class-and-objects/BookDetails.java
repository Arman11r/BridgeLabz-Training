
class BookDetails {

    // book information
    private String title;
    private String author;
    private double price;

    // constructor
    BookDetails(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }   
        

    // printing book data
    void displayBook() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }
// main method
    public static void main(String[] args) {
        // creating book objects
        BookDetails b1 = new BookDetails("2States", "Chetan Bhagat", 500);
        BookDetails b2 = new BookDetails("Wings Of Fire", "A P J Abdul Kalam", 500);
        // displaying book information usinf method
        b1.displayBook();
        b2.displayBook();
    }
}