package org.wikipedia.tests.android;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.wikipedia.annotations.JiraIssue;
import org.wikipedia.annotations.JiraIssues;
import org.wikipedia.annotations.Layer;
import org.wikipedia.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("android")
@Owner("egor.muratov")
@Layer("mobile")
@Feature("Search")
public class SearchTests extends TestBase {

    @Test
    @DisplayName("Successful search in wikipedia android app")
    @JiraIssues({@JiraIssue("HOM-232")})
    void searchTest() {
        back();
        step("Enter Harry Potter into the search bar", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("Harry Potter");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

}