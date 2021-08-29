package org.wikipedia.tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.wikipedia.annotations.Layer;
import org.wikipedia.tests.TestBase;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("egor.muratov")
@Layer("web")
@Feature("wiki search")
@Tag("web")
public class SearchTests extends TestBase {

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        step("Open url https://www.wikipedia.org/", () -> {
            open("https://www.wikipedia.org/");
        });
    }
}
