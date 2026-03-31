import java.util.*;

abstract class GoodsTransport {

    protected String transportId;
    protected String transportDate;
    protected int transportRating;

    public GoodsTransport(String transportId, String transportDate, int transportRating) {
        this.transportId = transportId;
        this.transportDate = transportDate;
        this.transportRating = transportRating;
    }

    public String getTransportId() {
        return transportId;
    }

    public String getTransportDate() {
        return transportDate;
    }

    public int getTransportRating() {
        return transportRating;
    }

    public abstract String vehicleSelection();

    public abstract float calculateTotalCharge();
}


class BrickTransport extends GoodsTransport {

    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId, String transportDate, int transportRating,
                          float brickSize, int brickQuantity, float brickPrice) {

        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    public int getBrickQuantity() {
        return brickQuantity;
    }

    public float getBrickPrice() {
        return brickPrice;
    }

    @Override
    public String vehicleSelection() {

        if (brickQuantity < 300)
            return "Truck";
        else if (brickQuantity <= 500)
            return "Lorry";
        else
            return "MonsterLorry";
    }

    @Override
    public float calculateTotalCharge() {

        float price = brickPrice * brickQuantity;
        float tax = price * 0.30f;

        float discount = 0;

        if (transportRating == 5)
            discount = price * 0.20f;
        else if (transportRating == 3 || transportRating == 4)
            discount = price * 0.10f;

        float vehiclePrice = getVehiclePrice(vehicleSelection());

        return (price + vehiclePrice + tax) - discount;
    }

    private float getVehiclePrice(String vehicle) {
        switch (vehicle.toLowerCase()) {
            case "truck": return 1000;
            case "lorry": return 1700;
            default: return 3000;
        }
    }
}


class TimberTransport extends GoodsTransport {

    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId, String transportDate, int transportRating,
                           float timberLength, float timberRadius,
                           String timberType, float timberPrice) {

        super(transportId, transportDate, transportRating);

        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

    public String getTimberType() {
        return timberType;
    }

    public float getTimberPrice() {
        return timberPrice;
    }

    @Override
    public String vehicleSelection() {

        float area = 2 * 3.147f * timberRadius * timberLength;

        if (area < 250)
            return "Truck";
        else if (area <= 400)
            return "Lorry";
        else
            return "MonsterLorry";
    }

    @Override
    public float calculateTotalCharge() {

        float volume = 3.147f * timberRadius * timberRadius * timberLength;

        float rate = timberType.equalsIgnoreCase("Premium") ? 0.25f : 0.15f;

        float price = volume * timberPrice * rate;

        float tax = price * 0.30f;

        float discount = 0;

        if (transportRating == 5)
            discount = price * 0.20f;
        else if (transportRating == 3 || transportRating == 4)
            discount = price * 0.10f;

        float vehiclePrice = getVehiclePrice(vehicleSelection());

        return (price + vehiclePrice + tax) - discount;
    }

    private float getVehiclePrice(String vehicle) {
        switch (vehicle.toLowerCase()) {
            case "truck": return 1000;
            case "lorry": return 1700;
            default: return 3000;
        }
    }
}


class Utility {

    public boolean validateTransportId(String transportId) {

        if (transportId.matches("RTS\\d{3}[A-Z]"))
            return true;

        System.out.println("Transport id " + transportId + " is invalid");
        System.out.println("Please provide a valid record");
        return false;
    }

    public GoodsTransport parseDetails(String input) {

        String[] d = input.split(":");

        String id = d[0];
        String date = d[1];
        int rating = Integer.parseInt(d[2]);
        String type = d[3];

        if (type.equalsIgnoreCase("BrickTransport")) {

            return new BrickTransport(
                    id, date, rating,
                    Float.parseFloat(d[4]),
                    Integer.parseInt(d[5]),
                    Float.parseFloat(d[6]));
        }
        else {

            return new TimberTransport(
                    id, date, rating,
                    Float.parseFloat(d[4]),
                    Float.parseFloat(d[5]),
                    d[6],
                    Float.parseFloat(d[7]));
        }
    }

    public String findObjectType(GoodsTransport obj) {

        if (obj instanceof TimberTransport)
            return "TimberTransport";
        else
            return "BrickTransport";
    }
}


public class FutureLogistics {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Utility util = new Utility();

        System.out.println("Enter the Goods Transport details");

        String input = sc.nextLine();

        String id = input.split(":")[0];

        if (!util.validateTransportId(id))
            return;

        GoodsTransport transport = util.parseDetails(input);

        float total = transport.calculateTotalCharge();

        System.out.println("Transporter id : " + transport.getTransportId());
        System.out.println("Date of transport : " + transport.getTransportDate());
        System.out.println("Rating of the transport : " + transport.getTransportRating());

        if (transport instanceof BrickTransport) {

            BrickTransport b = (BrickTransport) transport;
            System.out.println("Quantity of bricks : " + b.getBrickQuantity());
            System.out.println("Brick price : " + b.getBrickPrice());
        }
        else {

            TimberTransport t = (TimberTransport) transport;
            System.out.println("Type of the timber : " + t.getTimberType());
            System.out.println("Timber price per kilo : " + t.getTimberPrice());
        }

        System.out.println("Vehicle for transport : " + transport.vehicleSelection());
        System.out.println("Total charge : " + total);
    }
}