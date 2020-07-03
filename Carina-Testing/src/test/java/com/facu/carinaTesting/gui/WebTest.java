package com.facu.carinaTesting.gui;

import com.facu.carinaTesting.gui.pages.*;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest extends AbstractTest {

    @Test
    public void makeSearchTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened.");

        String search = "black";
        SearchPage searchPage = homePage.makeSearch(search);
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not opened.");
        Assert.assertTrue(searchPage.compareWords(search));
    }

    @Test
    public void loginTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened.");

        LoginPage loginPage = homePage.loginBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened.");

        AccountPage accountPage = loginPage.login("c.facu98@gmail.com", "qwerty");
        Assert.assertTrue(accountPage.isPageOpened(), "Account page is not opened.");

        Assert.assertTrue(accountPage.verifyLogin("Facundo Costa"));
    }

    @Test
    public void loginThenLogoutTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened.");

        LoginPage loginPage = homePage.loginBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened.");

        AccountPage accountPage = loginPage.login("c.facu98@gmail.com", "qwerty");
        Assert.assertTrue(accountPage.isPageOpened(), "Account page is not opened.");

        Assert.assertTrue(accountPage.verifyLogin("Facundo Costa"));

        loginPage = accountPage.logout();
        Assert.assertTrue(loginPage.isPageOpened(), "Couldn't logout.");
    }

    @Test
    public void addToCartTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened.");

        String search = "dress";
        SearchPage searchPage = homePage.makeSearch(search);
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not opened.");
        Assert.assertTrue(searchPage.compareWords(search));

        ExtendedWebElement item = searchPage.getFirstItem();
        ItemPage itemPage = searchPage.goToItemPage();
        Assert.assertTrue(itemPage.isPageOpened(), "Item page is not opened.");

        itemPage.addToCart();
        CartPage cartPage = itemPage.goToCartPage();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened.");
        cartPage.verifyCart();
    }
}
