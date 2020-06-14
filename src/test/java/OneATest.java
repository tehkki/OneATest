import org.junit.jupiter.api.Test;
import pages.BaseFunc;
import pages.HomePage;

public class OneATest {
    private final String URL = "http://www.1a.lv/";
    private BaseFunc baseFunc = new BaseFunc();

    private String categoryName = "telefoni";
    private String subCategoryName = "viedpulksteņi";
    private String subSubCategoryName = "rācijas";

    @Test
    public void oneTestA() {
        baseFunc.goToUrl(URL);
        HomePage homePage = new HomePage(baseFunc);
        homePage.clickOnItemNavigationMenuByName(categoryName);
        homePage.clickOnItemInSubMenuByName(subCategoryName);
        homePage.clickOnItemInListByName(subSubCategoryName);
    }


}