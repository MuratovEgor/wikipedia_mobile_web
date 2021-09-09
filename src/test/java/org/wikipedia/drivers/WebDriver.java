package org.wikipedia.drivers;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.wikipedia.config.Project;

public class WebDriver {

    public static void configure() {
        Configuration.browserVersion = Project.webConfig.getBrowserVersion();
        Configuration.browser = Project.webConfig.getBrowser();
        Configuration.browserSize = Project.webConfig.getBrowserSize();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.remote = Project.webConfig.getSelenoidUrl();
        Configuration.browserCapabilities = capabilities;
    }
}