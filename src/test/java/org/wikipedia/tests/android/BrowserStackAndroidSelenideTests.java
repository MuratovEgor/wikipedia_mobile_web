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
public class BrowserStackAndroidSelenideTests extends TestBase {

    @Test
    @DisplayName("Проверка работы поиска в приложении wikipedia на android")
    void searchTest() {
        step("Вводим в строку поиска Гарри Поттер", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("Гарри Поттер");
        });
        step("Проверка поиска", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Открытие экрана Setting")
    void openSettingScreen() {
        step("Тап на кнопку Меню", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });

        step("Нажать на кнопку Setting", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        });

        step("Проверится что осуществлен переход к экрану Setting", () -> {
            $(MobileBy.className("android.widget.TextView")).shouldHave(text("Setting"));
        });

    }
}