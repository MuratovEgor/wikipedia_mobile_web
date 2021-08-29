package org.wikipedia.helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.wikipedia.config.Project;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attach {
    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String attachVideo(String sessionId, String url) {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + url
                + "' type='video/mp4'></video></body></html>";
    }

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }

    public static void browserConsoleLogs() {
        attachAsText(
                "Browser console logs",
                String.join("\n", getWebDriverLogs(BROWSER))
        );
    }

    public static void addAttachments(String driver) {
        String sessionId;
        switch(driver) {
            case "SelenoidDriver":
                sessionId = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
                screenshotAs("Last screenshot");
                pageSource();
                attachVideo(sessionId, Project.selenoidConfig.getSelenoidVideoStorage() + sessionId + ".mp4");
                browserConsoleLogs();
                break;
            case "BrowserStackDriver":
                sessionId = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
                screenshotAs("Last screenshot");
                pageSource();
                attachVideo(sessionId,  Browserstack.videoUrl(sessionId));
                closeWebDriver();
                break;
            default:
                screenshotAs("Last screenshot");
                pageSource();
                closeWebDriver();
                break;
        }
    }
}