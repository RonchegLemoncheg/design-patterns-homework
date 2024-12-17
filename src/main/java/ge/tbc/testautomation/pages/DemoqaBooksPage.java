package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class DemoqaBooksPage {
    public ElementsCollection books = $$("div.rt-tr-group:has(img)");
}
