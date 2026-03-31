package json;

import java.io.InputStreamReader;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonRead {

    public static void main(String[] args) {

        try {

            JSONParser parser = new JSONParser();

            
            Reader reader = new InputStreamReader(
                    JsonRead.class.getClassLoader().getResourceAsStream("data.json")
            );

            JSONObject json = (JSONObject) parser.parse(reader);

            System.out.println("Name : " + json.get("name"));
            System.out.println("Age  : " + json.get("age"));
            System.out.println("Email: " + json.get("email"));

            reader.close();

        } catch (Exception e) {
            
            System.out.println("Unable to read JSON file");
        }
    }
}