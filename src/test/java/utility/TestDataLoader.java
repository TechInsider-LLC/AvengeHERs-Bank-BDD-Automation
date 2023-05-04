package utility;


import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;

public class TestDataLoader {

    public static final Map<String, Map<String,String>> testData;


    static {
        Yaml yaml = new Yaml();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("TestData.yml");
        testData = yaml.load(inputStream);
    }
}
