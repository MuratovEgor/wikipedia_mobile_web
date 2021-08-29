package org.wikipedia.drivers;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.wikipedia.config.Project;

public class SelenoidDriver {

    public static void configure() {
        Configuration.browserVersion = Project.selenoidConfig.getBrowserVersion();
        Configuration.browser = Project.selenoidConfig.getBrowser();
        Configuration.browserSize = Project.selenoidConfig.getBrowserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.remote = String.format(
                Project.selenoidConfig.getSelenoidUrl(),
                Project.selenoidConfig.getSelenoidUserName(),
                Project.selenoidConfig.getSelenoidUserPassword());

        Configuration.browserCapabilities = capabilities;
    }

}
