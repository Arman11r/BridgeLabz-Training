interface Converter {

    static double kmToMiles(double km) {
        return km * 0.621;
    }

    static double kgToLbs(double kg) {
        return kg * 2.204;
    }
}

public class ConvertTest {

    public static void main(String[] args) {

        System.out.println(Converter.kmToMiles(10));
    }
}