package json;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonMerger {

    public static void main(String[] args) {

        try {
        	

            ObjectMapper mapper = new ObjectMapper();

            JsonNode dataNode = mapper.readTree(
                    new File("src/main/resources/data.json")
            );

                    JsonNode employeeNode = mapper.readTree(
                    new File("src/main/resources/record.json")
            );

            
            ObjectNode mergedResult = (ObjectNode) dataNode;

            // attach array inside object
            mergedResult.set("employees", employeeNode);
                         
            // print final output
            System.out.println("Merged JSON:");
            System.out.println(
                    mapper.writeValueAsString(mergedResult)
            );

        } catch (Exception e) {
            System.out.println("Problem while merging");
        }
    }
}