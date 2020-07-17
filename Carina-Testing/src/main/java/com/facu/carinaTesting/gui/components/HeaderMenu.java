package com.facu.carinaTesting.gui.components;

import com.facu.carinaTesting.gui.pages.*;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(id = "search_query_top")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//form[@id='searchbox']/button")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//div[@id='header_logo']/a")
    private ExtendedWebElement homeLink;

    @FindBy(className = "login")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//header[@id='header']/div[@class='nav']/div/div/nav/div/a[@class='account']/span")
    private ExtendedWebElement accountBtn;

    @FindBy(xpath = "//header[@id='header']/div[@class='nav']/div/div/nav/div/a[@class='logout']")
    private ExtendedWebElement logoutBtn;

    @FindBy(xpath = "//div[@class='shopping_cart']/a")
    private ExtendedWebElement cartBtn;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeSearch(String search){
        searchInput.type(search);
    }

    public SearchPage clickSearchButton(){
        searchBtn.click();
        return new SearchPage(driver);
    }

    public HomePage clickHome(){
        homeLink.click();
        return new HomePage(driver);
    }

    public LoginPage clickLoginBtn(){
        loginBtn.click();
        return new LoginPage(driver);
    }

    public AccountPage clickAccountBtn(){
        accountBtn.click();
        return new AccountPage(driver);
    }

    public LoginPage clickLogoutBtn(){
        logoutBtn.click();
        return new LoginPage(driver);
    }

    public boolean verifyLogin(String name){
        return accountBtn.getText().equalsIgnoreCase(name);
    }

    public CartPage clickCart(){
        cartBtn.click();
        return new CartPage(driver);
    }
}
