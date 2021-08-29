package org.wikipedia.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.wikipedia.config.Project;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {
    private static URL getBrowserstackUrl() {
        try {
            return new URL(
                    String.format(
                            Project.browserStackConfig.getBrowserStackUrl(),
                            Project.browserStackConfig.getBrowserStackUser(),
                            Project.browserStackConfig.getBrowserStackKey())
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", Project.browserStackConfig.getBrowserStackUser());
        desiredCapabilities.setCapability("browserstack.key", Project.browserStackConfig.getBrowserStackKey());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", Project.browserStackConfig.getBrowserStackApp());
        desiredCapabilities.setCapability("app_url", Project.browserStackConfig.getAppUrl());

        // Specify device and os_version for testing Samsung Galaxy Tab S3 Google Pixel 3
        desiredCapabilities.setCapability("device", Project.browserStackConfig.getBrowserDevice());
        desiredCapabilities.setCapability("os_version", Project.browserStackConfig.getBrowserPlatformVersion());

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", Project.browserStackConfig.getBrowserStackProject());
        desiredCapabilities.setCapability("build", Project.browserStackConfig.getBrowserStackBuild());
        desiredCapabilities.setCapability("name", Project.browserStackConfig.getBrowserStackName());

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
