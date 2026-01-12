import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TempConvert {

  
    static class converttemp{

        static double celtofer(double cel) {
            return (cel * 9/5)+32;
        }

        static double ferToCel(double fer) {
            return (fer-32)*5/9;
        }
    }

  



    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(98.6,
                converttemp.celtofer(37),
                0.1);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(37,
                converttemp.ferToCel(98.6),
                0.1);
    }
}