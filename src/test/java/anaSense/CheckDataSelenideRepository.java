package anaSense;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckDataSelenideRepository {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void checkWikiAndSoftAssertions() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class}) " +
                "class Tests { " +
                "  @Test " +
                "  void test() { " +
                "    Configuration.assertionMode = SOFT; " +
                "    open(\"page.html\"); " +
                " " +
                "    $(\"#first\").should(visible).click(); " +
                "    $(\"#second\").should(visible).click(); " +
                "  } " +
                "}"));
    }
}
