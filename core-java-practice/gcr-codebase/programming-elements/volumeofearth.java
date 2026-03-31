public class volumeofearth {
    //volume of earth in. km^3 and miles^3
    public static void main(String[] args) {
        
        double r = 6378.0; // Radius of the Earth in kilometers
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
        // Convert volume to cubic miles
        double volumeInCubicMiles = volume * 0.239913; // 1 km^3 = 0.239913 miles^3
        System.out.println("The volume of the Earth in cubic kilometers is: " + volume + " cubic kilometers and in cubic miles is: " + volumeInCubicMiles + " cubic miles");
    }
}
