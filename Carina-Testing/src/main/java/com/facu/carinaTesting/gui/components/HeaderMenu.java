package com.facu.carinaTesting.gui.components;

import com.facu.carinaTesting.gui.pages.*;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu  extends AbstractUIObject {

    @FindBy(id = "search_query_top")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//*[@id=\"searchbox\"]/button")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//*[@id=\"header_logo\"]/a")
    private ExtendedWebElement homeLink;

    @FindBy(className = "login")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private ExtendedWebElement accountBtn;

    @FindBy(className = "logout")
    private ExtendedWebElement logoutBtn;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
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
