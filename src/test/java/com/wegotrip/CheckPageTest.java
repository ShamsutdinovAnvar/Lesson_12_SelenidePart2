package com.wegotrip;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckPageTest {

    @Test
    @DisplayName("Check enterprise page content")
    void openEnterprisePage() {
        open("https://github.com/");
        $(withText("Solutions")).hover();
        $(withText("Enterprise")).click();
//      $("h1").shouldHave(text("Build like the best"));
        $(byTagAndText("h1", "Build like the best")).shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Check drag and drop")
    void replaceRectangles() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
