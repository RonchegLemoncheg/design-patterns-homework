package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DemoqaPage {

    public SelenideElement userName = $("#userName");
    public SelenideElement userEmail =  $x("//input[@placeholder='name@example.com']");
    public SelenideElement currentAddress =  $("#currentAddress");
    public SelenideElement permanentAddress = $("#permanentAddress");
    public SelenideElement submitButton = $x("//button[text()='Submit']");
    public ElementsCollection results = $$x("//div[@id='output']//div//p");

}
