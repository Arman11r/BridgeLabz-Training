class UnitConverter {

    // this method convert fahrenheit to celsius
    public static double convertFahrenheitToCelsius(double fahrenheit) {

        // formula used for conversion

        double celsius = (fahrenheit - 32) * 5 / 9;

        return celsius;
    }

    // this method convert celsius to fahrenheit
    public static double convertCelsiusToFahrenheit(double celsius) {

        //formulae
        double fahrenheit = (celsius * 9 / 5) + 32;

        return fahrenheit;
    }

    // this method convert pounds to kilograms
    public static double convertPoundsToKilograms(double pounds) {

        // 1 pound is equal to 0.453592 kg
        double kilograms = pounds * 0.453592;

        return kilograms;
    }

    // this method convert kilograms to pounds
    public static double convertKilogramsToPounds(double kilograms) {

        // 1 kg is equal to 2.20462 pounds
        double pounds = kilograms * 2.20462;


        return pounds;
    }

    // this method convert gallons to liters
    public static double convertGallonsToLiters(double gallons) {

        double liters = gallons * 3.78541;

        return liters;
    }

    // this method convert liters to gallons
    public static double convertLitersToGallons(double liters) {

        double gallons = liters * 0.264172;

        return gallons;
    }

    public static void main(String[] args) {

        // testing all conversions one by one

        double fahrenheitValue = 100;
        System.out.println("Fahrenheit to Celsius: "


                + convertFahrenheitToCelsius(fahrenheitValue));

        double celsiusValue = 37;
        System.out.println("Celsius to Fahrenheit: "
                + convertCelsiusToFahrenheit(celsiusValue));

        double poundsValue = 10;
        System.out.println("Pounds to Kilograms: "
                + convertPoundsToKilograms(poundsValue));

        double kilogramsValue = 10;


        System.out.println("Kilograms to Pounds: "
                + convertKilogramsToPounds(kilogramsValue));

        double gallonsValue = 5;

        System.out.println("Gallons to Liters: "
                + convertGallonsToLiters(gallonsValue));



                //formulae
           double litersValue = 10;
        System.out.println("Liters to Gallons: "
                + convertLitersToGallons(litersValue));
    }
}