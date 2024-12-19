package ge.tbc.testautomation.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;

public class DemoqaSteps extends CommonSteps{
    @Step("Filling the field with value: {value}")
    public DemoqaSteps fillField(SelenideElement field, String value){
        field.setValue(value);
        return this;
    }

    @Step("Submitting the form by clicking the button")
    public DemoqaSteps submitForm(SelenideElement button){
        click(button);
        return this;
    }

    @Step("Validating the results: Username: {USERNAME}, User Email: {USEREMAIL}, Current Address: {CURRENTADDRESS}, Permanent Address: {PERMANENTADDRESS}")
    public DemoqaSteps validateResults(ElementsCollection result,
                                       String USERNAME, String USEREMAIL,
                                       String CURRENTADDRESS, String PERMANENTADDRESS){
        result.shouldHave(texts(
                USERNAME,
                USEREMAIL,
                CURRENTADDRESS,
                PERMANENTADDRESS));
        return this;

    }
}
