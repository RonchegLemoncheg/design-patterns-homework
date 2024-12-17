package ge.tbc.testautomation.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.texts;

public class DemoqaSteps extends CommonSteps{
    public DemoqaSteps fillField(SelenideElement field, String value){
        field.setValue(value);
        return this;
    }

    public DemoqaSteps submitForm(SelenideElement button){
        click(button);
        return this;
    }

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
