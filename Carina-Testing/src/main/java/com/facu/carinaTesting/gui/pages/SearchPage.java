package com.facu.carinaTesting.gui.pages;

import com.facu.carinaTesting.gui.components.HeaderMenu;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul")
    private List<ExtendedWebElement> resultList;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1/span[1]")
    private ExtendedWebElement wordSearched;

    @FindBy(id = "header")
    private HeaderMenu headerMenu;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean compareWords(String word){
        return wordSearched.getText().equalsIgnoreCase('"'+word+'"');
    }

    public ExtendedWebElement getFirstItem(){
        Assert.assertTrue(resultList.size() > 0, "No results");
        resultList.get(0).assertElementPresent();
        return resultList.get(0);
    }

    public ItemPage goToItemPage(){
        ExtendedWebElement item = getFirstItem();
        item.click();
        return new ItemPage(driver);
    }

}
