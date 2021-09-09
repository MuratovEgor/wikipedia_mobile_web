package org.wikipedia.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.wikipedia.config.Project;
import org.wikipedia.drivers.WebDriver;
import org.wikipedia.helpers.Attach;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        if (Objects.equals(Project.hostConfig.getDriver(), "WebDriver")) {
            WebDriver.configure();
        } else {
            Configuration.browser = "org.wikipedia.drivers." + Project.hostConfig.getDriver();
            Configuration.startMaximized = false;
            Configuration.browserSize = null;
            Configuration.timeout = 10000;
        }
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        Attach.addAttachments(Project.hostConfig.getDriver());
    }
}