class LibraryManagement {

    // node class for book
    static class Node {

        String title;
        String author;
        String genre;
        int bookId;
        boolean available;

        Node next;
        Node prev;

        // constructor to assign values
        Node(String title, String author, String genre, int bookId, boolean available) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.available = available;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;

    // add book at end
    public void addBook(String title, String author, String genre, int id, boolean status) {

        Node newNode = new Node(title, author, genre, id, status);

        // if list empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // linking new node
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // remove book using id
    public void removeBook(int id) {

        Node temp = head;

        // loop to find book
        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("book not found");
            return;
        }

        // if head remove
        if (temp == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }
        // if tail remove
        else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        // middle remove
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("book removed");
    }

    // update availability
    public void updateAvailability(int id, boolean status) {

        Node temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = status;
                System.out.println("availability updated");
                return;
            }
            temp = temp.next;
        }
// ssyso
        System.out.println("book not found");
    }

    // search book by title or author
    public void searchBook(String key) {

        Node temp = head;

        while (temp != null) {

            if (temp.title.equalsIgnoreCase(key) ||
                temp.author.equalsIgnoreCase(key)) {

                System.out.println("book found -> " + temp.title);
                return;
            }

            temp = temp.next;
        }

        System.out.println("book not found");
    }

    // display forward
    public void displayForward() {

        Node temp = head;

        System.out.println("library books forward");

        while (temp != null) {
            System.out.println(
                temp.title + " | " + temp.author +
                " | available: " + temp.available
            );
            temp = temp.next;
        }
    }

    // display reverse
    public void displayReverse() {

        Node temp = tail;

        System.out.println("library books reverse order");

        while (temp != null) {
            System.out.println(
                temp.title + " | " + temp.author +
                " | available: " + temp.available
            );
            temp = temp.prev;
        }
    }

    // count total books
    public void countBooks() {

        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("total books = " + count);
    }

    // main method
    public static void main(String[] args) {

        LibraryManagement library = new LibraryManagement();

        // adding books
        library.addBook("java basics", "arman", "education", 1, true);

        library.addBook("clean code", "shardul", "programming", 2, true);
        library.addBook("wings of fire", "apj abdul kalam", "biography", 3, false);

        // display books
        library.displayForward();
        library.displayReverse();

        // search book
        library.searchBook("apj abdul kalam");

        // update availability
        library.updateAvailability(3, true);

        // remove book
        library.removeBook(1);

        // count books
        library.countBooks();

        // display again
        library.displayForward();
    }
}