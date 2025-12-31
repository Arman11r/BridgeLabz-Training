// Doubly Linked List implementation for Movie records
class MovieNode {
    String title, director;
    int year;
    double rating;
    MovieNode next, prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

public class DoublyLinkedList {

    MovieNode head, tail;

    // add movie at end
    public void addMovie(String title, String director, int year, double rating) {
        MovieNode node = new MovieNode(title, director, year, rating);


            // first node
        if (head == null) {
            head = tail = node;
            return;
        }

// append at end
        tail.next = node;

    
        node.prev = tail;
        tail = node;
    }


    // delete movie by title
    public void deleteMovie(String title) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equals(title)) {
                if (temp.prev != null)
                    temp.prev.next = temp.next;
                else
                    head = temp.next;

                if (temp.next != null)
                    temp.next.prev = temp.prev;
                else
                    tail = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }

    // display forward
    public void displayForward() {
        MovieNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.rating);
            temp = temp.next;
        }
    }

    // display reverse
    public void displayReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addMovie("Inception", "Cristofer Nolan the best", 2010, 8.8);
        list.addMovie("Avatar", "James Cameron", 2009, 9.0);
//display
        list.displayForward();
        list.displayReverse();
    }
}