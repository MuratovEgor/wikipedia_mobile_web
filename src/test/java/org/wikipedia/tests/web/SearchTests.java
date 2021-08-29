package org.wikipedia.tests.web;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.wikipedia.annotations.Layer;
import org.wikipedia.tests.TestBase;

import static com.codeborne.selenide.Condition.text;
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
        step("Open url https://en.wikipedia.org/wiki/Main_Page", () -> {
            open("https://en.wikipedia.org/wiki/Main_Page");
        });

        step("Enter Harry Potter into the search bar", () -> {
            $("#searchInput").val("Harry Potter").pressEnter();
        });

        step("Check that the title of the article is Harry Potter", ()->{
            $("#firstHeading").shouldHave(text("Harry Potter"));
        });




    }
}
