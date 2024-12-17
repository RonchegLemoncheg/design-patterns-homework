package ge.tbc.testautomation.steps;

import com.codeborne.selenide.ElementsCollection;
import util.Util;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DemoqaBooksSteps {

    public DemoqaBooksSteps filterByPublisherAndTitle(ElementsCollection books, String publisher, String title){
        ElementsCollection filteredList = Util.filterList(books,publisher,title);
        return this;
    }

    public DemoqaBooksSteps filterByPublisherAndTitle(ElementsCollection books, String publisher, String title, SoftAssert softAssert, int expectedListSize){
        softAssert.assertEquals(Util.filterList(books,publisher,title).size(),expectedListSize);
        return this;
    }

    public DemoqaBooksSteps checkThatImagesAreNotEmpty(ElementsCollection books){
        books.forEach(book -> {
            String src = book.$("img").getAttribute("src");
            assert src != null;
            Assert.assertFalse(src.isEmpty());
        });
        return this;
    }

    public DemoqaBooksSteps checkNthBookName(ElementsCollection books, SoftAssert softAssert, int position, String bookName){
        softAssert.assertEquals(books.get(position).$("span.mr-2").getText(),bookName);
        return this;
    }
}
