package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;

public class EmailSchemaValidator {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new  ObjectMapper();
                JsonNode schemaNode =
                    mapper.readTree(new File("src/main/resources/schema.json"));

            JsonSchemaFactory factor = JsonSchemaFactory.byDefault();
            JsonSchema schema = factor.getJsonSchema(schemaNode);

                    JsonNode jsonData =
                    mapper.readTree(new File("src/main/resources/data.json"));

                    boolean valid = schema.validate(jsonData).isSuccess();

            if (valid) {
                System.out.println("valid Email.");
            } else {
                System.out.println("invalid Email.");
            }

        } catch (Exception e) {
            System.out.println("Error during JSON reading");
        }
    }
}