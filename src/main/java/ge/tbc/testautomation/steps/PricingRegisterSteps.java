package ge.tbc.testautomation.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.Objects;

public class PricingRegisterSteps extends CommonSteps{
    @Step("Filling the field with value: {value}")
    public PricingRegisterSteps fillField(SelenideElement field, String value){
        field.setValue(value);
        return this;
    }

    @Step("Verifying that the field is empty")
    public PricingRegisterSteps verifyFieldIsEmpty(SelenideElement field){
        Assert.assertTrue(Objects.requireNonNull(field.getValue()).isEmpty());
        return this;
    }
}
