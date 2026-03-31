package json;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXML {

    public static void main(String[] args) {

        try {

            ObjectMapper jsonMapper = new ObjectMapper();

            JsonNode jsonData = jsonMapper.readTree(
                    new File("src/main/resources/data.json")
            );

            XmlMapper xmlMap = new XmlMapper();

            String xmlOutput = xmlMap.writerWithDefaultPrettyPrinter().writeValueAsString(jsonData);

            System.out.println("Convert to XML:");
            System.out.println(xmlOutput);

        } catch (Exception e) {
            System.out.println("Error ");
        }
    }
}