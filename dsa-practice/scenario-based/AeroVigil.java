import java.util.*;


class InvalidFlightException extends Exception {

    public InvalidFlightException(String message) {
        super(message);
    }
}


class FlightUtil {
//
    public boolean validateFlightNumber(String flightNumber)
            throws InvalidFlightException {

        if (!flightNumber.matches("FL-\\d{4}")) {
            throw new InvalidFlightException(
                    "The flight number " + flightNumber + " is invalid");
        }

        int number = Integer.parseInt(flightNumber.substring(3));

        if (number < 1000 || number > 9999) {
            throw new InvalidFlightException(
                    "The flight number " + flightNumber + " is invalid");
        }

        return true;
    }


    public boolean validateFlightName(String flightName)
            throws InvalidFlightException {

        String[] validFlights = {
                "SpiceJet", "Vistara", "IndiGo", "Air Arabia"
        };

        for (String name : validFlights) {
            if (name.equalsIgnoreCase(flightName)) {
                return true;
            }
        }

        throw new InvalidFlightException(
                "The flight name " + flightName + " is invalid");
    }


    public boolean validatePassengerCount(int passengerCount, String flightName)
            throws InvalidFlightException {

        int maxCapacity = getMaxCapacity(flightName);

        if (passengerCount <= 0 || passengerCount > maxCapacity) {
            throw new InvalidFlightException(
                    "The passenger count " + passengerCount +
                            " is invalid for " + flightName);
        }

        return true;
    }


    public double calculateFuelToFillTank(String flightName, double currentFuelLevel)
            throws InvalidFlightException {

        double capacity = getFuelCapacity(flightName);

        if (currentFuelLevel < 0 || currentFuelLevel > capacity) {
            throw new InvalidFlightException(
                    "Invalid fuel level for " + flightName);
        }

        return capacity - currentFuelLevel;
    }


    // Helper methods (makes code cleaner)
    private int getMaxCapacity(String name) {

        switch (name.toLowerCase()) {
            case "spicejet": return 396;
            case "vistara": return 615;
            case "indigo": return 230;
            case "air arabia": return 130;
            default: return 0;
        }
    }

    private double getFuelCapacity(String name) {

        switch (name.toLowerCase()) {
            case "spicejet": return 200000;
            case "vistara": return 300000;
            case "indigo": return 250000;
            case "air arabia": return 150000;
            default: return 0;
        }
    }
}



public class AeroVigil {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FlightUtil util = new FlightUtil();

        System.out.println("Enter flight details");

        String input = scanner.nextLine();

        try {
            String[] data = input.split(":");

            String flightNumber = data[0];
            String flightName = data[1];
            int passengerCount = Integer.parseInt(data[2]);
            double fuelLevel = Double.parseDouble(data[3]);

            util.validateFlightNumber(flightNumber);
            util.validateFlightName(flightName);
            util.validatePassengerCount(passengerCount, flightName);

    
            double fuelRequired =
                    util.calculateFuelToFillTank(flightName, fuelLevel);

            System.out.println(
                    "Fuel required to fill the tank: " + fuelRequired + " liters");

        }
        catch (InvalidFlightException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Invalid input format");
        }

        scanner.close();
    }
}