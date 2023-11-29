package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class ТestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
//      Configuration.timeout = 5000; // default 4000
    }
}

