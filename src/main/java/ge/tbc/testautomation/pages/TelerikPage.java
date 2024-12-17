package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TelerikPage {
    public SelenideElement pricingLink = $x("//a[text()='Pricing' and not(contains(@class,'Footer'))]");
    public SelenideElement webSection = $x("//h2[text()='Web']/following::div[contains(@class, 'row u-mb8')]");
    public SelenideElement desktopSection = $x("//h2[text()='Desktop']/following::div[contains(@class, 'row u-mb8')]");
    public SelenideElement mobileSection = $x("//h2[text()='Mobile']/following::div[contains(@class, 'row u-mb8')]");
    public SelenideElement sectionLinks = $("nav.NavAlt.NavAlt--blue.u-bn.u-tal.u-b0");
}