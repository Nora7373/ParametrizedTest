package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class ТestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }
}

