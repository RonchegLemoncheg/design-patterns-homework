package ge.tbc.testautomation.steps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.PricingPage;
import io.qameta.allure.Step;
import util.TableHandler;
import org.testng.Assert;
import util.Util;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;

public class PricingSteps extends CommonSteps{
    PricingPage pricingPage = new PricingPage();

    @Step("Validating that the bundle does not support the feature: {feature}")
    public PricingSteps validateNotSupported(SelenideElement bundle, String feature){
        bundle.shouldNotHave(text(feature));

        return this;
    }

    @Step("Validating that the bundle supports the feature: {feature}")
    public PricingSteps validateSupported(SelenideElement bundle, String feature){
        bundle.shouldHave(text(feature));

        return this;
    }

    @Step("Validating that the feature: {forFeature} in bundle: {inBundle} is available with a dot")
    public PricingSteps validateAvailableWithDot(String forFeature, String inBundle){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                pricingPage.featureTable);
        dotCell.scrollTo().shouldHave(innerText("●"));
        return this;
    }

    @Step("Validating that the feature: {forFeature} in bundle: {inBundle} is not available with a dot")
    public PricingSteps validateNotAvailableWithDot(String forFeature, String inBundle){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                pricingPage.featureTable);
        dotCell.scrollTo().shouldNotHave(innerText("●"));
        return this;
    }

    @Step("Validating that feature: {forFeature} in bundle: {inBundle} shows instances: {instances} and users: {users}")
    public PricingSteps validateInstancesAndUsers(String forFeature, String inBundle, int instances, int users){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                pricingPage.featureTable);
        dotCell.scrollTo().shouldHave(innerText(String.format("%d instance with %d users", instances, users)));
        return this;
    }

    @Step("Checking sticky offer name behavior for elements")
    public PricingSteps checkStickyOfferNameBehavior(SelenideElement... elements){
        executeJavaScript("window.scrollTo(0, 0);");
        for (SelenideElement element :
                elements) {
            element.shouldBe(visible);
        }
        executeJavaScript("window.scrollBy(0, 2000);");
        for (SelenideElement element :
                elements) {
            element.shouldBe(visible);
        }
        return this;
    }

    @Step("Hovering over the offer and verifying the image becomes visible")
    public PricingSteps showsImageAfterHovering(SelenideElement offer, SelenideElement image){
        offer.$("div.Box-header").scrollIntoView("{block: 'center'}").hover();
        image.shouldBe(visible);
        return this;
    }

    @Step("Checking default support text for the offer: {text}")
    public PricingSteps checkDefaultSupport(SelenideElement offer,String text){
        offer.shouldHave(text(text));
        return this;
    }

    @Step("Verifying that the default support price for the offer is {price}")
    public PricingSteps checkDefaultSupportPrice(SelenideElement offer, int price){
//        String realPrice = offer.getText().replace(",","");
        double realPrice = Util.turnToNumber(offer);
        Assert.assertEquals(realPrice,price);
        return this;
    }

    @Step("Buying the offer with name: {offerName}")
    public PricingSteps buyOffer(String offerName){
        // es ar chavtvale sachirod rom calke gametana, saerto funqcia davwere sayidlad da amas am ertxel vxmarob
        SelenideElement pricings = $(byCssSelector("tr.Pricings-button"));
        offerName = offerName.replace("DevCraft ", "");
        SelenideElement button = pricings.$(String.format("th.%s", offerName)).$(byCssSelector("a"));
        button.scrollIntoView("{block: 'center'}").click();
        return this;
    }
}