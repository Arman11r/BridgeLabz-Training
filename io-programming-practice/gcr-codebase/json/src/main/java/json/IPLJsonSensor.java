package json;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;

import java.io.File;

public class IPLJsonSensor {

    public static void main(String[] args) {

        try {

            ObjectMapper mapper = new ObjectMapper();

   
            JsonNode root = mapper.readTree(
                    new File("src/main/resources/ipl.json")
            );

            ArrayNode matches = (ArrayNode) root;

            for (JsonNode match : matches) {

                ObjectNode obj = (ObjectNode) match;

                // censor team names
                obj.put("team1", maskTeam(obj.get("team1").asText()));
                obj.put("team2", maskTeam(obj.get("team2").asText()));

                
                obj.put("player_of_match", "REDACTED");
            }

    
            mapper.writerWithDefaultPrettyPrinter()
                  .writeValue(
                          new File("src/main/resources/ipl_censored.json"),
                          matches
                  );

            System.out.println("JSON censorship completed");

        } catch (Exception e) {
            System.out.println("Problem processing JSON data");
        }
    }

    // helper method
    private static String maskTeam(String team) {
        String[] parts = team.split(" ");
        return parts[0] + " ***";
    }
}