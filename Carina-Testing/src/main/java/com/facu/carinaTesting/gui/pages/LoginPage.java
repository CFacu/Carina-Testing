package com.facu.carinaTesting.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "email")
    private ExtendedWebElement emailInput;

    @FindBy(id = "passwd")
    private ExtendedWebElement passInput;

    @FindBy(id = "SubmitLogin")
    private ExtendedWebElement signInBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage login(String email, String pass){
        emailInput.type(email);
        passInput.type(pass);
        signInBtn.click();
        return new AccountPage(driver);

    }
}
