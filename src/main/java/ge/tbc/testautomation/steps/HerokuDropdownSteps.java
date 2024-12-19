package ge.tbc.testautomation.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class HerokuDropdownSteps {
    @Step("Validating that the selected option in the dropdown is: {text}")
    public HerokuDropdownSteps validateSelected(SelenideElement dropdown, String text){
        dropdown.getSelectedOption().shouldHave(text(text));
        return this;
    }

    @Step("Selecting the option: {text} in the dropdown")
    public HerokuDropdownSteps selectOption(SelenideElement dropdown, String text){
        dropdown.selectOption(text);
        return this;
    }

}
