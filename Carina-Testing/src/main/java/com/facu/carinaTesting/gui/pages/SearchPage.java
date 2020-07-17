package com.facu.carinaTesting.gui.pages;

import com.facu.carinaTesting.gui.components.HeaderMenu;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='center_column']/ul")
    private List<ExtendedWebElement> resultList;

    @FindBy(xpath = "//div[@id='center_column']/h1/span[@class='lighter']")
    private ExtendedWebElement wordSearched;

    @FindBy(id = "header")
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//div[@id='center_column']/p")
    private ExtendedWebElement notFoundMsg;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean compareWords(String word){
        if (wordSearched.isElementPresent()) {
            return wordSearched.getText().equalsIgnoreCase('"' + word + '"');
        } else return notFoundMsg.isElementPresent();
    }

    public ExtendedWebElement getFirstItem(){
        if (resultList.size() > 0) {
            return resultList.get(0);
        } else return null;
    }

    public ItemPage goToItemPage(){
        ExtendedWebElement item = getFirstItem();
        item.click();
        return new ItemPage(driver);
    }

}
