package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class GoogleTests extends TestBase{
    @Test
    void positiveSelenideSearchTest () {

        open("https://www.google.com");

        $(byName("q")).setValue("Selenide").pressEnter();

        $("html").shouldHave(text("Selenide"));
    }

    @Test
    void negativeSelenideSearchTest () {

        open("https://www.google.com");

        $(byName("q")).setValue("Selenide").pressEnter();

        $("html").shouldHave(text("ru.selenide.org"));
    }
}
