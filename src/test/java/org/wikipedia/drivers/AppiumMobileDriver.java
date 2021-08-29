package org.wikipedia.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.wikipedia.config.Project;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumMobileDriver implements WebDriverProvider {
    private static URL getAppiumUrl() {
        try {
            return new URL(
                    Project.appiumConfig.getHubUrl()
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability("platformName", Project.appiumConfig.getPlatformName());
        capabilities.setCapability("deviceName", Project.appiumConfig.getDevice());
        capabilities.setCapability("version", Project.appiumConfig.getPlatformVersion());
        capabilities.setCapability("locale", Project.appiumConfig.getPlatformLocale());
        capabilities.setCapability("language", Project.appiumConfig.getPlatformLanguage());
        capabilities.setCapability("appPackage", Project.appiumConfig.getAppPackage());
        capabilities.setCapability("appActivity", Project.appiumConfig.getAppActivity());
        capabilities.setCapability("app", Project.appiumConfig.getAppUrl());

        return new AndroidDriver(getAppiumUrl(), capabilities);
    }

}
