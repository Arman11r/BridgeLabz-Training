package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class FilterUsersByAge {

    public static void main(String[] args) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            JsonNode rootNode = mapper.readTree(
                    new File("src/main/resources/users.json")
            );

            System.out.println("Users older than 25 extracted:");

            // loop through each user object
            for (JsonNode userNode : rootNode) {

                int age = userNode.get("age").asInt();

                if (age > 25) {
                    System.out.println("Name  : " +
                    userNode.get("name").asText());
                    
                    System.out.println("Age   : " + 
                    age);
                    
                    System.out.println("Email : " +
                    userNode.get("email").asText());
                    
                }
            }

        } catch (Exception e) {
            System.out.println("Unable to read or filter JSON data");
        }
    }
}