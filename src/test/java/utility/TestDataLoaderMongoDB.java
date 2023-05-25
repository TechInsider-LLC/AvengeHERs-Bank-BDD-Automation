package utility;

import com.mongodb.client.*;
import org.bson.Document;


import java.util.HashMap;
import java.util.Map;

public class TestDataLoaderMongoDB {
    public static final Map<String, Map<String,String>> testData;

    static {
        MongoClient mongoClient = MongoClients.create("mongodb://mongoadmin:secretmongo@0.tcp.ngrok.io:12760/");
        MongoDatabase database = mongoClient.getDatabase("test-data");
        MongoCollection<Document> collection = database.getCollection("stage-test-data");

        FindIterable<Document> documents = collection.find();

        testData = new HashMap<>();
        for (Document doc : documents) {
            String testName = doc.getString("test_name");
            Document testDataDoc = (Document) doc.get("test_data");
            Map<String,String> testDataMap = new HashMap<>();
            for (String key : testDataDoc.keySet()) {
                testDataMap.put(key, testDataDoc.getString(key));
            }
            testData.put(testName, testDataMap);
        }

        mongoClient.close();
    }
}
