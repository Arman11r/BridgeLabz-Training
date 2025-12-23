
class MovieTicket {

    // ticket details
    private String movieName;
    private String seatNumber;
    private double price;
    private boolean isBooked;

    // constructor
    MovieTicket(String movieName) {
        this.movieName = movieName;
        this.isBooked = false;
    }

    // booking ticket
    void bookTicket(String seatNumber, double price) {

        if (isBooked) {
            System.out.println("ticket already booked");
        } else {
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;

            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: " + price);
        }
    }

    // display ticket info
    void displayTicket() {
//  showing ticket details
        if (isBooked) {
            System.out.println("Movie: " + movieName);
            System.out.println("Seat: " + seatNumber);
            System.out.println("Price: " + price);
        } else {
            System.out.println("ticket not booked yet");
        }
    }

    public static void main(String[] args) {
// creating movie ticket object
        MovieTicket ticket =
                new MovieTicket("Dragon");
// displaying ticket info before booking
        ticket.displayTicket();
        ticket.bookTicket("A10", 120);
        ticket.bookTicket("B11", 120);
        ticket.displayTicket();
    }
}