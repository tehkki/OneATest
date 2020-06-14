package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage {
    public BaseFunc baseFunc;
    private final By ITEM_NAVIGATE_MENU = By.xpath(".//div[@class = 'submenu-lvl1 submenu-lvl1" +
            "--invisible submenu-lvl1--index']/ul/li/a");
    private final By ITEMS_IN_SUB_MENU = By.xpath(".//div[@class = 'filter-block only-desktop']/ul/li");
    private final By ITEMS_IN_SUB_SUB_MENU= By.xpath(".//ul[@class = 'child-category']/li");

public HomePage (BaseFunc baseFunc){
    this.baseFunc = baseFunc;
}

public HomePage clickOnItemNavigationMenuByName(String name){
    List<WebElement> categoryNames = baseFunc.getElements(ITEM_NAVIGATE_MENU);
    baseFunc.clickOnElementContainsName(categoryNames,name);
    return this;
}

public HomePage clickOnItemInSubMenuByName (String name){
    baseFunc.waitForElements(ITEMS_IN_SUB_MENU);
    List<WebElement> subCategoryNames = baseFunc.getElements(ITEMS_IN_SUB_MENU);
    baseFunc.clickOnElementContainsName(subCategoryNames,name);
    return this;
}

public HomePage clickOnItemInListByName (String name){
    baseFunc.waitForElements(ITEMS_IN_SUB_SUB_MENU);
    List<WebElement> subSubCategoryNames = baseFunc.getElements(ITEMS_IN_SUB_SUB_MENU);
    baseFunc.clickOnElementContainsName(subSubCategoryNames,name);
    return this;
}

}
