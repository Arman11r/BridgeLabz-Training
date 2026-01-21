package json;
import java.io.*;

public class IPLCsvCensor {

    public static void main(String[] args) {

        String input = "src/main/resources/ipl.csv";
        String output = "src/main/resources/iplcensored.csv";

        try {

            BufferedReader reader = new BufferedReader(new FileReader(input));
            FileWriter writer = new FileWriter(output);

            String line;

            // copy header as-is
            writer.write(reader.readLine() + "\n");

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                // censor team names
                data[1] = maskTeam(data[1]);
                data[2] = maskTeam(data[2]);
                data[5] = maskTeam(data[5]);

               
                data[6] = "REDACTED";

                writer.write(String.join(",", data) + "\n");
            }

            reader.close();
            writer.close();

            System.out.println("CSV censorship completed");

        } catch (Exception e) {
            System.out.println("Problem processing CSV file");
        }
    }

    private static String maskTeam(String team) {
        String[] parts = team.split(" ");
        return parts[0] + " ***";
    }
}