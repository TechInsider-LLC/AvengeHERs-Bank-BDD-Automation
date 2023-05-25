package utility;

import io.cucumber.java.en.Given;

import java.util.Map;

public class ScenarioDataMongoDB {

    private static Map<String, String> scenariodatamongodb;


    @Given("Customer has test data for {string} in MongoDB")
    public void customer_has_test_data_for_in_mongo_db(String feature) {
        scenariodatamongodb = TestDataLoaderMongoDB.testData.get(feature);
    }

    public static String get(String key) {
        return scenariodatamongodb.get(key);
    }
}
