package ge.tbc.testautomation.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import util.Util;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TelerikSteps extends CommonSteps{

    public TelerikSteps validateOnHoverPurple(SelenideElement mainDiv){
        ElementsCollection columns = mainDiv.$$x(".//div[img]");
        Util.validatePurple(columns);
        return this;
    }

    public TelerikSteps validateTextOnHover(SelenideElement mainDiv, String elementName, String text){
        ElementsCollection columns = mainDiv.$$x(".//div[div//img]");
        Util.validateHoverText(columns, elementName, text);
        return this;
    }

    public TelerikSteps filterByStore(SelenideElement mainDiv, String storeName){
        ElementsCollection columns = mainDiv.$$x(".//div[div//img]");
        List<SelenideElement> filteredColumns = Util.filterByStoreName(columns,storeName);
        return this;
    }

    public TelerikSteps validateAvailableOnStores(SelenideElement section, String itemName, String[] stores){
        SelenideElement item = section.$x(String.format(".//div[h3[text()='%s']]",itemName));
        Arrays.stream(stores).forEach(e ->
                Assert.assertFalse(Util.filterByStoreName(item, e).isEmpty()));
        return this;
    }

    public TelerikSteps validateIsFixed(SelenideElement section){
        executeJavaScript("window.scrollTo(0, 500);");
        String posBeforeScrolling = section.getCssValue("position");
        executeJavaScript("window.scrollBy(0, 2000);");
        String posAfterScrolling = section.getCssValue("position");
        Assert.assertEquals(posAfterScrolling, posBeforeScrolling);
        return this;
    }

    public TelerikSteps validateSectionLinksActivation(SelenideElement section){
        ElementsCollection sectionLinks = section.$$x(".//div[@class='container']//a");
        Util.validateSectionLinks(sectionLinks);
        return this;
    }

    public TelerikSteps validateSectionLinksSections(SelenideElement section){
        executeJavaScript("window.scrollTo(0, 0);");
        ElementsCollection sectionLinks = section.$$x(".//div[@class='container']//a");
        Util.validateSectionLinksWorking(sectionLinks);
        return this;
    }


}