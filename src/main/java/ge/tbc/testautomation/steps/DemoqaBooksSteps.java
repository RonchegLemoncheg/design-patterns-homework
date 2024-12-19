package ge.tbc.testautomation.steps;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import util.Util;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DemoqaBooksSteps {

    @Step("Filtering books by publisher: {publisher} and title: {title}")
    public DemoqaBooksSteps filterByPublisherAndTitle(ElementsCollection books, String publisher, String title){
        ElementsCollection filteredList = Util.filterList(books,publisher,title);
        return this;
    }

    @Step("Filtering books by publisher: {publisher}, title: {title}, and verifying list size is: {expectedListSize}")
    public DemoqaBooksSteps filterByPublisherAndTitle(ElementsCollection books, String publisher, String title, SoftAssert softAssert, int expectedListSize){
        softAssert.assertEquals(Util.filterList(books,publisher,title).size(),expectedListSize);
        return this;
    }

    @Step("Checking that images for all books are not empty")
    public DemoqaBooksSteps checkThatImagesAreNotEmpty(ElementsCollection books){
        books.forEach(book -> {
            String src = book.$("img").getAttribute("src");
            assert src != null;
            Assert.assertFalse(src.isEmpty());
        });
        return this;
    }

    @Step("Checking the name of the book at position: {position} is: {bookName}")
    public DemoqaBooksSteps checkNthBookName(ElementsCollection books, SoftAssert softAssert, int position, String bookName){
        softAssert.assertEquals(books.get(position).$("span.mr-2").getText(),bookName);
        return this;
    }
}
