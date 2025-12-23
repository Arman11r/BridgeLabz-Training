class HotelBooking {

    // guest name
    String guestName;

    // room type
    String roomType;

    // total nights
    int nights;

    // default constructor
    HotelBooking() {
        // assigning default booking
        guestName = "guest";
        roomType = "standard";
        nights = 1;
    }

    // parameter constructor
    HotelBooking(String guestName, String roomType, int nights) {
        // assigning values
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // copy constructor
    HotelBooking(HotelBooking h) {
        // copying booking details
        this.guestName = h.guestName;
        this.roomType = h.roomType;
        this.nights = h.nights;
    }

    // showing booking details
    void display() {
        System.out.println(guestName + " " + roomType + " nights " + nights);
    }

    public static void main(String[] args) {

        // creating booking
        HotelBooking b1 = new HotelBooking("Aman", "Deluxe", 3);

        // copying booking
        HotelBooking b2 = new HotelBooking(b1);

        // showing both
        b1.display();
        b2.display();
    }
}