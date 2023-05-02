package utility;

import io.cucumber.java.en.Given;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestDataLoader {

    public static final Map<String, Map<String,String>> testData;

    static {
        Yaml yaml = new Yaml();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("TestData.yml");
        testData = yaml.load(inputStream);
    }
}
