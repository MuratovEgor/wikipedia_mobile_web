package org.wikipedia.tests.android;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.wikipedia.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class SettingTests extends TestBase {

    @Test
    @DisplayName("Open the Settings screen")
    void openSettingScreen() {
        step("Tap on the Menu button", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });

        step("Tap on the Setting button", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        });

        step("Verify that have navigated to the Setting screen", () -> {
            $(MobileBy.className("android.widget.TextView")).shouldHave(text("Setting"));
        });

    }
}