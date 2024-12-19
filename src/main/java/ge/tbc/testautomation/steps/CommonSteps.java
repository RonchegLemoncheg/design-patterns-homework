package ge.tbc.testautomation.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class CommonSteps {

    @Step("Clicking the element")
    public CommonSteps click(SelenideElement element){
        element.scrollIntoView("{block: 'center'}").click();
        return this;
    }
}
