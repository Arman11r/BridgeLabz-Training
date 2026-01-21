package json;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CsvToJson {

    public static void main(String[] args) {

        String filePath = "src/main/resources/json.csv";

        ArrayList<HashMap<String, String>> studentList = new ArrayList<>();

        try {

            BufferedReader bufferrdr = new BufferedReader(new FileReader(filePath));

            String headerLine = bufferrdr.readLine();  
            String[] headers = headerLine.split(",");

            String row;

            while ((row = bufferrdr.readLine()) != null) {

                String[] values = row.split(" , ");

                HashMap<String, String> student = new HashMap<>();

                for (int i = 0; i < headers.length; i++) {
                    student.put(headers[i], values[i]);
                }

                studentList.add(student);
            }

      

            ObjectMapper mapper = new ObjectMapper();

         
            String jsonData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentList);

            System.out.println("JSON Output: ");
            System.out.println(jsonData);

        } catch (Exception e) {
            System.out.println("Something went wrong  CSV");
        }
    }
}