package tests;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class GoogleTests {
    @Test
    void selenideSearchTest () {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        open("https://www.google.com");

        $(byName("q")).setValue("Selenide").pressEnter();

        $("html").shouldHave(text("Selenide"));
    }
}
