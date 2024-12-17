package ge.tbc.testautomation.steps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.PricingPage;
import util.TableHandler;
import org.testng.Assert;
import util.Util;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;

public class PricingSteps extends CommonSteps{
    PricingPage pricingPage = new PricingPage();

    public PricingSteps validateNotSupported(SelenideElement bundle, String feature){
        bundle.shouldNotHave(text(feature));

        return this;
    }

    public PricingSteps validateSupported(SelenideElement bundle, String feature){
        bundle.shouldHave(text(feature));

        return this;
    }

    public PricingSteps validateAvailableWithDot(String forFeature, String inBundle){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                pricingPage.featureTable);
        dotCell.scrollTo().shouldHave(innerText("●"));
        return this;
    }

    public PricingSteps validateNotAvailableWithDot(String forFeature, String inBundle){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                pricingPage.featureTable);
        dotCell.scrollTo().shouldNotHave(innerText("●"));
        return this;
    }

    public PricingSteps validateInstancesAndUsers(String forFeature, String inBundle, int instances, int users){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                pricingPage.featureTable);
        dotCell.scrollTo().shouldHave(innerText(String.format("%d instance with %d users", instances, users)));
        return this;
    }

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

    public PricingSteps showsImageAfterHovering(SelenideElement offer, SelenideElement image){
        offer.$("div.Box-header").scrollIntoView("{block: 'center'}").hover();
        image.shouldBe(visible);
        return this;
    }

    public PricingSteps checkDefaultSupport(SelenideElement offer,String text){
        offer.shouldHave(text(text));
        return this;
    }

    public PricingSteps checkDefaultSupportPrice(SelenideElement offer, int price){
//        String realPrice = offer.getText().replace(",","");
        double realPrice = Util.turnToNumber(offer);
        Assert.assertEquals(realPrice,price);
        return this;
    }

    public PricingSteps buyOffer(String offerName){
        // es ar chavtvale sachirod rom calke gametana, saerto funqcia davwere sayidlad da amas am ertxel vxmarob
        SelenideElement pricings = $(byCssSelector("tr.Pricings-button"));
        offerName = offerName.replace("DevCraft ", "");
        SelenideElement button = pricings.$(String.format("th.%s", offerName)).$(byCssSelector("a"));
        button.scrollIntoView("{block: 'center'}").click();
        return this;
    }
}