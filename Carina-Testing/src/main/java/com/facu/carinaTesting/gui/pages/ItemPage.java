package com.facu.carinaTesting.gui.pages;

import com.facu.carinaTesting.gui.components.HeaderMenu;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends AbstractPage {

    @FindBy(id = "header")
    private HeaderMenu headerMenu;

    @FindBy(id = "add_to_cart")
    private ExtendedWebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")
    private ExtendedWebElement continueBtn;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(){
        addToCartBtn.click();
        pause(3);
        continueBtn.clickIfPresent();
    }

    public CartPage goToCartPage(){
        return headerMenu.clickCart();
    }
}
