package com.facu.carinaTesting.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"cart_summary\"]/tbody")
    private List<ExtendedWebElement> itemsList;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void verifyCart(){
        Assert.assertTrue(itemsList.size() > 0, "Nothing in the cart");
        itemsList.get(0).assertElementPresent();
    }


}
