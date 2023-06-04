package utility;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Config {

    @Data
    public static class BrowserConfig {
        @JsonProperty("platformName")
        private String platformName;

        @JsonProperty("browserVersion")
        private String browserVersion;

    }

    @Data
    public static class SauceOptions {
        @JsonProperty("username")
        private String username;

        @JsonProperty("accessKey")
        private String accessKey;

        @JsonProperty("build")
        private String build;

        @JsonProperty("name")
        private String name;

    }

    @JsonProperty("chromeOptions")
    private BrowserConfig chromeOptions;

    @JsonProperty("chromeSauceOptions")
    private SauceOptions chromeSauceOptions;

    @JsonProperty("safariOptions")
    private BrowserConfig safariOptions;

    @JsonProperty("safariSauceOptions")
    private SauceOptions safariSauceOptions;

    @JsonProperty("url")
    private String url;


}
