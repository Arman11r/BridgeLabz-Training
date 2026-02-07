package json;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CarToJson {

    public static void main(String[] args) {

        try {

            Car myCar = new Car(
                    11,
                    "mercedize",
                    "benz",
                    1500000
            );

            ObjectMapper mapper = new ObjectMapper();

            String jsonOutput = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(myCar);

            System.out.println("Car JSON Data:  ");
            System.out.println(jsonOutput);

        } catch (Exception e) {
            System.out.println("Problem while converting ");
        }
    }
}