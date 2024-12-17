package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.checked;

public class HerokuCheckboxSteps {
    public HerokuCheckboxSteps setFirstCheckboxSelected(ElementsCollection checkboxes){
        checkboxes.first().setSelected(true).shouldBe(checked);
        return this;
    }

    public HerokuCheckboxSteps validateCheckboxes(ElementsCollection checkboxes){
        checkboxes.forEach(checkbox ->
                checkbox.shouldHave(Condition.attribute("type", "checkbox")));
        return this;
    }
}
