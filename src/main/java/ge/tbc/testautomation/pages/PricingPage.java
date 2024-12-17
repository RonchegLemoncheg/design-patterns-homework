package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.data.Constants;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class PricingPage {
    public SelenideElement devCraftUIBundlePricingInfo = $(byCssSelector("tr.Pricings-info"))
            .$(byCssSelector("th.UI.is-active"));
    public SelenideElement devCraftCompleteBundlePricingInfo = $(byCssSelector("tr.Pricings-info"))
            .$(byCssSelector("th.Complete"));
    public SelenideElement devCraftUltimateBundlePricingInfo = $(byCssSelector("tr.Pricings-info"))
            .$(byCssSelector("th.Ultimate"));
    public SelenideElement devCraftUIBundlePricingSupport = $(byCssSelector("tr.Pricings-support"))
            .$(byCssSelector("th.UI.is-active"));
    public SelenideElement devCraftCompleteBundlePricingSupport = $(byCssSelector("tr.Pricings-support"))
            .$(byCssSelector("th.Complete"));
    public SelenideElement devCraftUltimateBundlePricingSupport = $(byCssSelector("tr.Pricings-support"))
            .$(byCssSelector("th.Ultimate"));
    public SelenideElement featureTable = $(byCssSelector("table.PricingTable"));
    public SelenideElement devCraftUILabel = $(byTagAndText("h5", Constants.DEVCRAFT_UI));
    public SelenideElement devCraftCompleteLabel = $(byTagAndText("h5", Constants.DEVCRAFT_COMPLETE));
    public SelenideElement devCraftUltimateLabel = $(byTagAndText("h5", Constants.DEVCRAFT_ULTIMATE));
    public SelenideElement individualProductsLabel = $(byTagAndText("span", Constants.INDIVIDUAL_PRODUCTS)).parent().parent();
    public SelenideElement individualKendoUI = $(byAttribute("data-opti-expid", Constants.KENDO_UI));
    public SelenideElement kendoUINinja = $(byTitle("Kendo Ui Ninja"));
    public SelenideElement individualKendoUIDefaultOption = individualKendoUI.$("div.Dropdown a");
    public SelenideElement individualKendoUIDefaultPrice = individualKendoUI.$("span.js-price");
    public SelenideElement individualKendoReact = $(byAttribute("data-opti-expid", Constants.KENDOREACT));
    public SelenideElement kendoReactNinja = $(byTitle("Kendo React Ninja"));
    public SelenideElement individualKendoReactDefaultOption = individualKendoReact.$("div.Dropdown a");
    public SelenideElement individualKendoReactDefaultPrice = individualKendoReact.$("span.js-price");
    public SelenideElement ultimatePrice = $("tr.Pricings-value th.Ultimate span.u-dib");

}