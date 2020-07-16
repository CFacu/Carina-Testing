package com.facu.carinaTesting.gui.pages;

import com.facu.carinaTesting.gui.exceptions.NoItemsException;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"cart_summary\"]/tbody")
    private List<ExtendedWebElement> itemsList;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement verifyCart() throws NoItemsException {
        if (itemsList.size() > 0){
            return itemsList.get(0);
        } else {
            throw new NoItemsException("There is no items in the cart.");
        }
    }
}