package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PricingRegisterPage {
    public SelenideElement firstName = $("#biFirstName");
    public SelenideElement lastName = $("#biLastName");
    public SelenideElement email = $("#biEmail");
    public SelenideElement company = $("#biCompany");
    public SelenideElement phone = $("#biPhone");
    public SelenideElement address = $("#biAddress");
    public SelenideElement country = $("input.k-input-inner");
    public SelenideElement city = $("#biCity");
    public SelenideElement zipCode = $("#biZipCode");
    public SelenideElement backButton = $("a.loader-button");
}
