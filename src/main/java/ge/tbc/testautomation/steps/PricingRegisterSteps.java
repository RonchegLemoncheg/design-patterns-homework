package ge.tbc.testautomation.steps;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import java.util.Objects;

public class PricingRegisterSteps extends CommonSteps{
    public PricingRegisterSteps fillField(SelenideElement field, String value){
        field.setValue(value);
        return this;
    }

    public PricingRegisterSteps verifyFieldIsEmpty(SelenideElement field){
        Assert.assertTrue(Objects.requireNonNull(field.getValue()).isEmpty());
        return this;
    }
}
