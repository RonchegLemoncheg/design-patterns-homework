package ge.tbc.testautomation.steps;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;

public class HerokuDropdownSteps {
    public HerokuDropdownSteps validateSelected(SelenideElement dropdown, String text){
        dropdown.getSelectedOption().shouldHave(text(text));
        return this;
    }

    public HerokuDropdownSteps selectOption(SelenideElement dropdown, String text){
        dropdown.selectOption(text);
        return this;
    }

}
