package com.facu.carinaTesting.gui.services;

import com.facu.carinaTesting.gui.pages.AccountPage;
import com.facu.carinaTesting.gui.pages.HomePage;
import com.facu.carinaTesting.gui.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

public interface ILogin {

    default Optional<AccountPage> login(WebDriver driver, String email, String pass) {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        LoginPage loginPage = homePage.loginBtn();

        AccountPage accountPage = loginPage.login(email,pass);

        if (!loginPage.isInvalidPass()) {
            return Optional.of(accountPage);
        } else {
            return Optional.empty();
        }
    }
}
