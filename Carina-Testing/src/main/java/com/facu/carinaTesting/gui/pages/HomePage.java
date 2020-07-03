package com.facu.carinaTesting.gui.pages;

import com.facu.carinaTesting.gui.components.HeaderMenu;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id = "header")
    private HeaderMenu headerMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public SearchPage makeSearch(String movie){
        headerMenu.typeSearch(movie);
        return headerMenu.clickSearchButton();
    }

    public LoginPage loginBtn(){
        return headerMenu.clickLoginBtn();
    }
}
