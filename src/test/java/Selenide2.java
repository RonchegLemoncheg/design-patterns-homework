import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.*;
import ge.tbc.testautomation.retry.RetryAnalyzer;
import ge.tbc.testautomation.retry.RetryCount;
import ge.tbc.testautomation.steps.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import util.Util;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.ByteArrayInputStream;

import static com.codeborne.selenide.Selenide.open;
@Test(groups = "Selenide 2")
public class Selenide2 extends BaseTest{

    TelerikPage telerikPage;
    TelerikSteps telerikSteps;
    PricingPage pricingPage;
    PricingSteps pricingSteps;
    StorePage storePage;
    StoreSteps storeSteps;
    PricingRegisterPage pricingRegisterPage;
    PricingRegisterSteps pricingRegisterSteps;
    DemoqaBooksPage demoqaBooksPage;
    DemoqaBooksSteps demoqaBooksSteps;

    @BeforeClass
    public void setUp(){
        telerikPage = new TelerikPage();
        telerikSteps = new TelerikSteps();
        pricingPage = new PricingPage();
        pricingSteps = new PricingSteps();
        storePage = new StorePage();
        storeSteps = new StoreSteps();
        pricingRegisterPage = new PricingRegisterPage();
        pricingRegisterSteps = new PricingRegisterSteps();
        demoqaBooksPage = new DemoqaBooksPage();
        demoqaBooksSteps = new DemoqaBooksSteps();
    }


    //magalitistvis yvela tests displayname-c davuwere da description

    @Test
    @Feature("UI Elements and Interactions")
    @Story("Telerik Web Section Design")
    @DisplayName("Validate Telerik Web Section Design and Interactions")
    @Description("This test validates hover interactions and section behaviors in Telerik web sections.")
    @Severity(SeverityLevel.CRITICAL)
    public void validateDemosDesign(){
        open(Constants.TELERIK_LINK);
        telerikSteps.
                validateOnHoverPurple(telerikPage.webSection)
                .validateTextOnHover(telerikPage.webSection, Constants.KENDO_UI, Constants.UI_FOR_VUE_DEMOS)
                .filterByStore(telerikPage.desktopSection, Constants.MICROSOFT)
                .validateAvailableOnStores(telerikPage.mobileSection, Constants.TELERIK_UI_FOR_XAMARIN, new String[]{Constants.MICROSOFT, Constants.GOOGLE, Constants.APP_STORE})
                .validateIsFixed(telerikPage.sectionLinks)
                .validateSectionLinksActivation(telerikPage.sectionLinks)
                .validateSectionLinksSections(telerikPage.sectionLinks);

    }


    @Test
    @Feature("Store and Pricing")
    @Story("Order Mechanics and Pricing Validation")
    @DisplayName("Validate Telerik Order Mechanics and Pricing")
    @Description("This test verifies that the order mechanics and pricing for Telerik products are correct on the store page.")
    @Severity(SeverityLevel.CRITICAL)
    public void validateOrderMechanics(){
        open(Constants.TELERIK_LINK);
        telerikSteps.click(telerikPage.pricingLink);
        // amas shemdeg viyeneb da stale element rom ar mqondes aq vinaxav
        double ultimatePrice = Util.turnToNumber(pricingPage.ultimatePrice);
        pricingSteps.buyOffer(Constants.DEVCRAFT_ULTIMATE);
        storeSteps.
                dismissLoginRequest(storePage.loginRequest)
                .pricesAreEqual(ultimatePrice,storePage.unitPrice)
                .increaseQuantityTo(storePage.dropdown, Constants.TWO)
                .checkIfSavingsIsValid(storePage.savingsPrice, ultimatePrice)
                .validateSubtotal(storePage.unitPrice, Constants.TWO, storePage.subtotalPrice)
                .validateTotalDiscounts(storePage.totalDiscounts)
                .validateTotalPrice(storePage.subtotalPrice, storePage.totalPrice)
                .click(storePage.registerButton);

        pricingRegisterSteps.
                fillField(pricingRegisterPage.firstName, Constants.USERNAME)
                .fillField(pricingRegisterPage.lastName, Constants.LASTNAME)
                .fillField(pricingRegisterPage.email, Constants.USEREMAIL)
                .fillField(pricingRegisterPage.company, Constants.COMPANYNAME)
                .fillField(pricingRegisterPage.phone, Constants.PHONENUMBER)
                .fillField(pricingRegisterPage.address, Constants.CURRENT_ADDRESS)
                .fillField(pricingRegisterPage.country, Constants.COUNTRY)
                .fillField(pricingRegisterPage.city, Constants.CITY)
                .fillField(pricingRegisterPage.zipCode, Constants.ZIPCODE)
                .click(pricingRegisterPage.backButton);
        storeSteps.click(storePage.registerButton);

        pricingRegisterSteps.
                verifyFieldIsEmpty(pricingRegisterPage.firstName)
                .verifyFieldIsEmpty(pricingRegisterPage.lastName)
                .verifyFieldIsEmpty(pricingRegisterPage.email)
                .verifyFieldIsEmpty(pricingRegisterPage.company)
                .verifyFieldIsEmpty(pricingRegisterPage.phone)
                .verifyFieldIsEmpty(pricingRegisterPage.address)
                .verifyFieldIsEmpty(pricingRegisterPage.country)
                .verifyFieldIsEmpty(pricingRegisterPage.city)
                .verifyFieldIsEmpty(pricingRegisterPage.zipCode);
    }

    @Test
    @Feature("Book Search and Validation")
    @Story("DemoQA Books Search")
    @DisplayName("Validate Book Search and Image Display on DemoQA Platform")
    @Description("This test checks the functionality of the DemoQA books search by publisher and title and ensures that images are displayed for the books.")
    @Severity(SeverityLevel.NORMAL)
    public void chainedLocatorsTest(){
        open(Constants.DEMOQA_BOOKS_LINK);
        demoqaBooksSteps.
                filterByPublisherAndTitle(demoqaBooksPage.books, Constants.REILLY_MEDIA, Constants.JAVASCRIPT)
                .checkThatImagesAreNotEmpty(demoqaBooksPage.books);

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @RetryCount(count = 2)
    @Feature("Book Search and Validation")
    @Story("Soft Assert for Book Search")
    @DisplayName("Validate Book Search with Soft Assert")
    @Description("This test uses a soft assert to validate the books search by publisher and title on DemoQA platform.")
    @Severity(SeverityLevel.MINOR)
    public void softAssertTest(){
        open(Constants.DEMOQA_BOOKS_LINK);
        SoftAssert softAssert = new SoftAssert();
        demoqaBooksSteps.
                filterByPublisherAndTitle(demoqaBooksPage.books, Constants.REILLY_MEDIA, Constants.JAVASCRIPT, softAssert, Constants.TEN)
                .checkNthBookName(demoqaBooksPage.books, softAssert, Constants.ZERO, Constants.GIT_POCKET_GUIDE);
        softAssert.assertAll();
    }
}
