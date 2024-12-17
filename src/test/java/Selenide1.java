import ge.tbc.testautomation.pages.*;
import ge.tbc.testautomation.steps.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;
@Test(groups = "Selenide 1")
public class Selenide1 extends BaseTest{
    TelerikPage telerikPage;
    TelerikSteps telerikSteps;
    PricingPage pricingPage;
    PricingSteps pricingSteps;
    HerokuCheckboxPage herokuCheckboxPage;
    HerokuCheckboxSteps herokuCheckboxSteps;
    HerokuDropdownPage herokuDropdownPage;
    HerokuDropdownSteps herokuDropdownSteps;
    DemoqaPage demoqaPage;
    DemoqaSteps demoqaSteps;

    @BeforeClass
    public void setUp(){
        telerikPage = new TelerikPage();
        telerikSteps = new TelerikSteps();
        pricingPage = new PricingPage();
        pricingSteps = new PricingSteps();
        herokuCheckboxPage = new HerokuCheckboxPage();
        herokuCheckboxSteps = new HerokuCheckboxSteps();
        herokuDropdownPage = new HerokuDropdownPage();
        herokuDropdownSteps = new HerokuDropdownSteps();
        demoqaPage = new DemoqaPage();
        demoqaSteps = new DemoqaSteps();
    }


    @Test
    public void validateBundleOffers() {
        open(TELERIK_LINK);
        telerikSteps.click(telerikPage.pricingLink);
        pricingSteps.
                validateNotSupported(pricingPage.devCraftUIBundlePricingInfo, MOCKING_SOLUTION_FEATURE)
                .validateNotSupported(pricingPage.devCraftUIBundlePricingSupport, ISSUE_ESCALATION)
                .validateNotSupported(pricingPage.devCraftCompleteBundlePricingSupport, ISSUE_ESCALATION)
                .validateSupported(pricingPage.devCraftUltimateBundlePricingSupport, ISSUE_ESCALATION)
                .validateNotSupported(pricingPage.devCraftUIBundlePricingInfo, REPORT_MANAGEMENT_SOLUTION)
                .validateNotSupported(pricingPage.devCraftCompleteBundlePricingInfo, REPORT_MANAGEMENT_SOLUTION)
                .validateSupported(pricingPage.devCraftUltimateBundlePricingInfo, REPORT_MANAGEMENT_SOLUTION)
                .validateNotAvailableWithDot(TEST_STUDIO, DEVCRAFT_UI)
                .validateNotAvailableWithDot(TEST_STUDIO, DEVCRAFT_COMPLETE)
                .validateAvailableWithDot(TEST_STUDIO, DEVCRAFT_ULTIMATE)
                .validateAvailableWithDot(JQUERY, DEVCRAFT_UI)
                .validateAvailableWithDot(JQUERY, DEVCRAFT_COMPLETE)
                .validateAvailableWithDot(JQUERY, DEVCRAFT_ULTIMATE)
                .validateInstancesAndUsers(REPORT_SERVER, DEVCRAFT_ULTIMATE, REPORT_SERVER_INSTANCES, REPORT_SERVER_USERS)
                .validateNotAvailableWithDot(REPORTING, DEVCRAFT_UI)
                .validateAvailableWithDot(REPORTING, DEVCRAFT_COMPLETE)
                .validateAvailableWithDot(REPORTING, DEVCRAFT_ULTIMATE)
                .validateAvailableWithDot(ON_DEMAND_VIDEOS, DEVCRAFT_UI)
                .validateAvailableWithDot(ON_DEMAND_VIDEOS, DEVCRAFT_COMPLETE)
                .validateAvailableWithDot(ON_DEMAND_VIDEOS, DEVCRAFT_ULTIMATE)
                .checkStickyOfferNameBehavior(
                        pricingPage.devCraftUILabel,
                        pricingPage.devCraftCompleteLabel,
                        pricingPage.devCraftUltimateLabel);
    }


    @Test
    public void validateIndividualOffers(){
        open(TELERIK_LINK);
        telerikSteps.click(telerikPage.pricingLink).click(pricingPage.individualProductsLabel);
        pricingSteps.
                showsImageAfterHovering(pricingPage.individualKendoUI,pricingPage.kendoUINinja)
                .showsImageAfterHovering(pricingPage.individualKendoReact,pricingPage.kendoReactNinja)
                .checkDefaultSupport(pricingPage.individualKendoUIDefaultOption,PRIORITY_SUPPORT)
                .checkDefaultSupport(pricingPage.individualKendoUIDefaultOption,PRIORITY_SUPPORT)
                .checkDefaultSupportPrice(pricingPage.individualKendoUIDefaultPrice,KENDO_UI_PRIORITY_PRICE)
                .checkDefaultSupportPrice(pricingPage.individualKendoReactDefaultPrice,KENDOREACT_PRIORITY_PRICE);

    }

    @Test(groups = "CheckBoxes-FrontEnd", priority = 2)
    public void checkBoxTest(){
        open(HEROKU_CHECKBOX);
        herokuCheckboxSteps.
                setFirstCheckboxSelected(herokuCheckboxPage.checkBoxes)
                .validateCheckboxes(herokuCheckboxPage.checkBoxes);
    }

    @Test(groups = "dropDown-FrontEnd", priority = 1)
    public void dropDownTest(){
        open(HEROKU_DROPDOWN);
        herokuDropdownSteps.
                validateSelected(herokuDropdownPage.dropdownMenu, PLEASE_SELECT_AN_OPTION)
                .selectOption(herokuDropdownPage.dropdownMenu, OPTION_2)
                .validateSelected(herokuDropdownPage.dropdownMenu, OPTION_2);
    }

    @Test
    public void collectionsTest(){
        // testngshi miweria rom mxolod firefoxshi gaeshvas
        open(DEMOQA_FORM_LINK);
        demoqaSteps.
                fillField(demoqaPage.userName, USERNAME)
                .fillField(demoqaPage.userEmail,USEREMAIL)
                .fillField(demoqaPage.currentAddress, CURRENT_ADDRESS)
                .fillField(demoqaPage.permanentAddress, PERMANENT_ADDRESS)
                .submitForm(demoqaPage.submitButton)
                .validateResults(demoqaPage.results, USERNAME, USEREMAIL, CURRENT_ADDRESS, PERMANENT_ADDRESS);
    }
}