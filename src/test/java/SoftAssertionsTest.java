import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SoftAssertionsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920 х 1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
}
@Test
void SoftAssertionTest(){

//Откройте страницу Selenide в Github
    open("/selenide/selenide");

//Перейдите в раздел Wiki проекта
    $("#wiki-tab").click();

    $(".wiki-more-pages-link button").click();

//Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions

    $("#wiki-pages-box").shouldBe(visible).$(byText("SoftAssertions")).click();

//Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
    $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
            "class Tests {\n" +
            "  @Test\n" +
            "  void test() {\n" +
            "    Configuration.assertionMode = SOFT;\n" +
            "    open(\"page.html\");\n" +
            "\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n" +
            "}"));
     }
}
