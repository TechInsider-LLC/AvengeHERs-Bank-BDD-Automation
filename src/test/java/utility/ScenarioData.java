package utility;

import io.cucumber.java.en.Given;

import java.util.Map;

public class ScenarioData {

    private static Map<String, String> scenariodata;

    @Given("Customer has test data for {string}")
    public void customer_has_test_data_for(String feature) {
            scenariodata = TestDataLoader.testData.get(feature);
    }

    public static String get(String key) {
         return scenariodata.get(key);
    }
}
