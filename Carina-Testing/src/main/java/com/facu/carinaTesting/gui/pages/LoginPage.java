package com.facu.carinaTesting.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends AbstractPage {

    @FindBy(id = "email")
    private ExtendedWebElement emailInput;

    @FindBy(id = "passwd")
    private ExtendedWebElement passInput;

    @FindBy(id = "SubmitLogin")
    private ExtendedWebElement signInBtn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/ol/li")
    private ExtendedWebElement invalidPassTxt;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage login(String email, String pass){
        emailInput.type(email);
        passInput.type(pass);
        signInBtn.click();
        return new AccountPage(driver);

    }

    public void isInvalidPass() {
        Assert.assertNotNull(invalidPassTxt);
    }
}
