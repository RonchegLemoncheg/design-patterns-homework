package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class HerokuCheckboxPage {
    public ElementsCollection checkBoxes = $$("input[type='checkbox']");
}
