package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import util.Util;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class StoreSteps extends CommonSteps{
    public StoreSteps dismissLoginRequest(SelenideElement loginRequest){
        loginRequest.$("i").should(exist).shouldBe(visible).click();
        return this;
    }

    public StoreSteps pricesAreEqual(double price1, SelenideElement price2){
        double newPrice = Util.turnToNumber(price2);
        Assert.assertEquals(price1,newPrice);
        return this;
    }

    public StoreSteps increaseQuantityTo(SelenideElement dropdown, String quantity){
        dropdown.click();
        $(".k-list-content").$$("li").find(Condition.text(quantity)).click();
        return this;
    }

    public StoreSteps checkIfSavingsIsValid(SelenideElement savingsPrice, double realPrice){
        double priceOfOneDiscount = Util.turnToNumber(savingsPrice);
        Assert.assertEquals(Math.round(priceOfOneDiscount),Math.round(realPrice*0.05));
        return this;
    }

    public StoreSteps validateSubtotal(SelenideElement unitPrice, String quantity, SelenideElement totalPrice){
        double unitsPrice = Util.turnToNumber(unitPrice)*Integer.parseInt(quantity);
        Assert.assertEquals(unitsPrice,Util.turnToNumber(totalPrice));
        return this;
    }

    public StoreSteps validateTotalDiscounts(SelenideElement totalDiscount){
        // es ar chavtvale sachirod rom pageshi gavitano, ertxel vxmarob mxolod
        $("div.e2e-total-discounts-label").scrollIntoView("{block: 'center'}").hover();
        double discount = Util.turnToNumber($("div.tooltip-info.td-tooltip")
                .shouldBe(visible).$("div.u-fr"));
        double discountOther = Util.turnToNumber(totalDiscount);
        Assert.assertEquals(discount,discountOther);
        return this;
    }

    public StoreSteps validateTotalPrice(SelenideElement subtotal, SelenideElement total){
        double subtotalPrice = Util.turnToNumber(subtotal);
        double totalPrice = Util.turnToNumber(total);
        Assert.assertEquals(subtotalPrice,totalPrice);
        return this;
    }
}
