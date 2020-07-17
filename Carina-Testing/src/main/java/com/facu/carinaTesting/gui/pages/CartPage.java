package com.facu.carinaTesting.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='order-detail-content']/table/tbody")
    private List<ExtendedWebElement> itemsList;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyCart(){
        return itemsList.size() > 0;
    }
}