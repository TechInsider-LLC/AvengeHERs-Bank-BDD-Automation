package utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestDataMigration {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://testdatauser:password@localhost:27017/test-data");


        MongoDatabase database = mongoClient.getDatabase("test-data");
        MongoCollection<Document> collection = database.getCollection("stage-test-data");

        Path path = Paths.get("src/test/resources/TestData.yml");

        try {
            String content = Files.readString(path);
            ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
            ObjectMapper jsonWriter = new ObjectMapper();

            Map<String, Map<String, String>> dataMap = yamlReader.readValue(content, Map.class);

            for (Map.Entry<String, Map<String, String>> entry : dataMap.entrySet()) {
                String json = jsonWriter.writeValueAsString(entry.getValue());
                Document doc = new Document("test_name", entry.getKey()).append("test_data", Document.parse(json));
                collection.insertOne(doc);
            }

            System.out.println("Inserted documents.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        mongoClient.close();
    }
}
