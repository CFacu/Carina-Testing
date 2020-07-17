package com.facu.carinaTesting.gui.pages;

import com.facu.carinaTesting.gui.components.HeaderMenu;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    @FindBy(id = "header")
    private HeaderMenu headerMenu;

    public AccountPage(WebDriver driver) {
        super(driver);
        setPageURL("?controller=my-account");
    }

    public boolean verifyLogin(String name){
        return headerMenu.verifyLogin(name);
    }

    public LoginPage logout(){
        return headerMenu.clickLogoutBtn();
    }

    public SearchPage makeSearch(String movie){
        headerMenu.typeSearch(movie);
        return headerMenu.clickSearchButton();
    }

}
