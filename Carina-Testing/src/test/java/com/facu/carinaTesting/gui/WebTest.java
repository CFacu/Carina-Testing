package com.facu.carinaTesting.gui;

import com.facu.carinaTesting.gui.pages.*;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest extends AbstractTest {

    @Test(description = "Tests the searchbar")
    @MethodOwner(owner = "Facundo")
    public void makeSearchTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened.");

        String search = "black";
        SearchPage searchPage = homePage.makeSearch(search);
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not opened.");
        Assert.assertTrue(searchPage.compareWords(search));
    }

    @Test(description = "Test login with valid credentials")
    @MethodOwner(owner = "Facundo")
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

    @Test(description = "Test login with invalid credentials")
    @MethodOwner(owner = "Facundo")
    public void loginNegativeTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened.");

        LoginPage loginPage = homePage.loginBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened.");

        loginPage.login("c.facu98@gmail.com", "qweqwe");
        loginPage.isInvalidPass();

    }

    @Test(description = "Test logout after login")
    @MethodOwner(owner = "Facundo")
    public void logoutTest(){
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

    @Test(description = "Test searching for a product and adding it to the cart")
    @MethodOwner(owner = "Facundo")
    public void addToCartTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened.");

        String search = "dress";
        SearchPage searchPage = homePage.makeSearch(search);
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not opened.");
        Assert.assertTrue(searchPage.compareWords(search));

        ItemPage itemPage = searchPage.goToItemPage();
        Assert.assertTrue(itemPage.isPageOpened(), "Item page is not opened.");

        itemPage.addToCart();
        CartPage cartPage = itemPage.goToCartPage();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened.");
        cartPage.verifyCart();
    }
}
