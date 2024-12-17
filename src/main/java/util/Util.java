package util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByTagAndText;
import ge.tbc.testautomation.data.Constants;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$x;

public class Util {
    public static void validatePurple(ElementsCollection columns){
        columns.forEach(e -> {
            e.$x(".//img").scrollIntoView("{block: 'center'}").hover();
            String color = e.getCssValue("background-color");
            Assert.assertEquals(color, Constants.PURPLE_COLOR);
        });
    }

    public static void validateHoverText(ElementsCollection columns, String elementName, String text){
        SelenideElement element = columns.stream()
                .filter(e -> e.$x(".//h3").getText().contains(elementName))
                .findFirst()
                .orElse(null);
        assert element != null;
        element.$x(".//img").scrollIntoView("{block: 'center'}").hover();
        element.$$x(".//a").findBy(Condition.text(text)).should(exist);
    }

    public static List<SelenideElement> filterByStoreName(Object columns, String storeName) {
        // es ase imito miweria rom armindoda calke funqcia damewera meore stepistvis
        // sadac vamowmeb rom 3 stores tu sheicavs
        if (columns instanceof SelenideElement item) {
            return item.$x(String.format(".//img[contains(@title, '%s')]", storeName)).exists() ? List.of(item) : List.of();
        } else if (columns instanceof ElementsCollection list) {
            return list.stream()
                    .filter(e -> e.$x(String.format(".//img[contains(@title, '%s')]", storeName)).exists())
                    .toList();
        }
        return List.of();
    }

    public static void validateSectionLinks(ElementsCollection sectionLinks1){
        sectionLinks1.forEach(element -> {
            element.shouldNotHave(cssClass("is-active"));
            element.shouldBe(visible);
            String beforeScrolling = element.getCssValue("background-color");
            String sectionName = element.getText();
            if (!sectionName.equals("Sitefinity CMS")) $x("//h2[text()='" + sectionName + "']").scrollTo();
            else $x("//h2[text()='Web Content Management']").scrollTo();
            // aq vamowmeb rom roca mag seqciaze gadadis, feri icvleba da klass is-active emateba
            element.shouldHave(cssClass("is-active"));
            element.shouldNotHave(cssValue("background-color", "rgba(0, 0, 0, 0)"));
            String afterScrolling = element.shouldNotHave(attribute("style", "background-color: rgba(0, 0, 0, 0);"))
                    .getCssValue("background-color");
            Assert.assertNotEquals(beforeScrolling, afterScrolling);
        });
    }

    public static void validateSectionLinksWorking(ElementsCollection sectionLinks1){
        sectionLinks1.forEach(element -> {
            String sectionName;
            if (!element.getText().equals("Sitefinity CMS")) sectionName=element.getText();
            else sectionName="Web Content Management";
            element.scrollIntoView("{block: 'center'}").click();
            Assert.assertTrue($x("//h2[text()='"+sectionName+"']").isDisplayed());
        });
    }

    public static double turnToNumber(SelenideElement price){
        return Double.parseDouble(price.getText()
                .replace(",","")
                .replace("- $", "")
                .replace("US $", "")
                .replace("Save $", "")
                .replace("$", ""));
    }

    public static ElementsCollection filterList(ElementsCollection books, String publisher, String title) {
        return books.filter(text(publisher))
                .filter(text(title));
    }
}
