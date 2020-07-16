package com.facu.carinaTesting.gui.services;

import com.facu.carinaTesting.gui.pages.AccountPage;
import com.facu.carinaTesting.gui.pages.HomePage;
import com.facu.carinaTesting.gui.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public interface ILogin {

    default AccountPage login(WebDriver driver, String email, String pass) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened.");

        LoginPage loginPage = homePage.loginBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened.");

        return loginPage.login(email, pass);
    }

}
