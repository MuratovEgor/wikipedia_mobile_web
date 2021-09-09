package org.wikipedia.tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.wikipedia.annotations.JiraIssue;
import org.wikipedia.annotations.JiraIssues;
import org.wikipedia.annotations.Layer;
import org.wikipedia.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("egor.muratov")
@Layer("web")
@Feature("Main page")
@Tag("web")
public class LoginTests extends TestBase {
    @Test
    @DisplayName("Unsuccessful login")
    @JiraIssues({@JiraIssue("HOM-232")})
    void unsuccessfulLogin() {
        step("Open url Login Page", () ->
                open("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page")
        );
        step("Type test in Login field", () -> $("#wpName1").val("test"));
        step("Type test in Password field", () -> $("#wpPassword1").val("test"));
        step("Click button Log in", () -> $("#wpLoginAttempt").click());
        step("Check that block Error is visible", () -> $(".errorbox").shouldBe(visible));
    }
}
