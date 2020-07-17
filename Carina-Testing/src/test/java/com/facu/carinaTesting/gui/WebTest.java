package com.facu.carinaTesting.gui;

import com.facu.carinaTesting.gui.pages.*;
import com.facu.carinaTesting.gui.services.ILogin;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

public class WebTest extends AbstractTest implements ILogin {

    @Test(dataProvider = "SingleDataProvider", description = "Tests the searchbar")
    @MethodOwner(owner = "Facundo")
    @XlsDataSourceParameters(path = "xls/autpractice.xlsx", sheet = "searches", dsUid = "TUID", dsArgs = "search")
    public void makeSearchTest(String search){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened.");

        SearchPage searchPage = homePage.makeSearch(search);
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not opened.");
        Assert.assertTrue(searchPage.compareWords(search));
    }

    @Test(description = "Test login with valid credentials")
    @MethodOwner(owner = "Facundo")
    public void loginTest() {
        String email = "c.facu98@gmail.com";
        String pass = "qwerty";

        Optional<AccountPage> accountPage = login(getDriver(), email, pass);

        Assert.assertTrue(accountPage.isPresent());
        Assert.assertTrue(accountPage.get().verifyLogin("Facundo Costa"));
    }

    @Test(description = "Test login with invalid credentials")
    @MethodOwner(owner = "Facundo")
    public void loginNegativeTest() {
        String email = "c.facu98@gmail.com";
        String pass = "qweqwqwe";

        Optional<AccountPage> accountPage = login(getDriver(), email, pass);

        Assert.assertFalse(accountPage.isPresent());
    }

    @Test(description = "Test logout after login")
    @MethodOwner(owner = "Facundo")
    public void logoutTest(){
        String email = "c.facu98@gmail.com";
        String pass = "qwerty";
        Optional<AccountPage> accountPage = login(getDriver(), email, pass);
        Assert.assertTrue(accountPage.isPresent());

        Assert.assertTrue(accountPage.get().verifyLogin("Facundo Costa"));

        LoginPage loginPage = accountPage.get().logout();
        Assert.assertTrue(loginPage.isPageOpened(), "Couldn't logout.");
    }

    @Test(dataProvider = "DP1", description = "Test searching for a product and adding it to the cart")
    @MethodOwner(owner = "Facundo")
    public void addToCartTest(String TUID, String search) {

        String email = "c.facu98@gmail.com";
        String pass = "qwerty";

        Optional<AccountPage> accountPage = login(getDriver(), email, pass);
        Assert.assertTrue(accountPage.isPresent());

        SearchPage searchPage = accountPage.get().makeSearch(search);
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not opened.");
        Assert.assertTrue(searchPage.compareWords(search));

        ItemPage itemPage = searchPage.goToItemPage();
        Assert.assertTrue(itemPage.isPageOpened(), "Item page is not opened.");

        itemPage.addToCart();
        CartPage cartPage = itemPage.goToCartPage();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened.");

        Assert.assertTrue(cartPage.verifyCart());
    }

    @DataProvider(name = "DP1")
    public static Object[][] dataprovider() {
        return new Object[][] {
                {"TUID: Data1", "dress"},
                //{"TUID: Data2", "shirt"}, QUESTION: Why the item list takes the second.
                {"TUID: Data3", "black"}
        };
    }
}
