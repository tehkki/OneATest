package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BaseFunc {
    private final String HOME_PAGE_URL = "1a.lv";
    private WebDriver driver;
    private WebDriverWait wait;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
    }

    public void goToUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        driver.get(url);
    }

    public List<WebElement> getElements(By locator) {
        assertFalse(driver.findElements(locator).isEmpty(), "No elements found by this locator");
        return driver.findElements(locator);
    }

    public void waitForElements(By locator) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void clickOnElementContainsName(List<WebElement> listOfElements, String name) {
        for (WebElement we : listOfElements) {
            if (we.getText().toLowerCase().contains(name)) {
                we.click();
                break;
            }
        }
    }
}
