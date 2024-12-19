package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.checked;

public class HerokuCheckboxSteps {
    @Step("Selecting the first checkbox and ensuring it is checked")
    public HerokuCheckboxSteps setFirstCheckboxSelected(ElementsCollection checkboxes){
        checkboxes.first().setSelected(true).shouldBe(checked);
        return this;
    }
    @Step("Validating that all elements in the collection are checkboxes")
    public HerokuCheckboxSteps validateCheckboxes(ElementsCollection checkboxes){
        checkboxes.forEach(checkbox ->
                checkbox.shouldHave(Condition.attribute("type", "checkbox")));
        return this;
    }
}
