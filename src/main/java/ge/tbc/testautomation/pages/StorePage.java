package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StorePage {
    public SelenideElement loginRequest = $x("//h6[text()='Sign up or Log in ']").parent().parent();
    public SelenideElement unitPrice = $("span.e2e-price-per-license");
    public SelenideElement savingsPrice = $("div.e2e-item-licenses-savings");
    public SelenideElement subtotalPrice = $("div.e2e-cart-item-subtotal");
    public SelenideElement totalPrice = $("h4.e2e-total-price");
    public SelenideElement totalDiscounts = $("span.e2e-total-discounts-price");
    public SelenideElement dropdown = $("kendo-dropdownlist");
    public SelenideElement registerButton = $("button.loader-button");

}
