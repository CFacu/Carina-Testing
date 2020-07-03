package com.facu.carinaTesting.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FooterMenu extends AbstractUIObject {

    @FindBy(id = "//*[@id=\"block_various_links_footer\"]/ul")
    private List<ExtendedWebElement> informationMenu;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void selectOnInformationMenu(String option) {
        for (ExtendedWebElement element : informationMenu) {
            if (element.getText().equalsIgnoreCase(option)){
                element.click();
            }
        }
    }
}
