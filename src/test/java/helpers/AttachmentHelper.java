package helpers;

import com.codeborne.selenide.commands.TakeScreenshot;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AttachmentHelper {
    @Attachment(value = "{AttachName}", type = "text/plan")
    public static String attachAsText(String attachName, String message) { return message; }

    @Attachment(value = "{AttachName}", type = "image/png")
    public static byte[] attachScreenshot(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page Source", type = "text/plan")
    public static byte[] attachPageSource() {return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);}
}
