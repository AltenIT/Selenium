import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidateHeader
{
    WebDriver webDriver;

    @BeforeClass
    public void SetUp() {
        webDriver = new ChromeDriver();
    }

    @Test (priority = 1)
    public void VisitGoogle() {
        webDriver.get("http://localhost:8090/shoppingcart/#/home");
    }

    @Test (priority = 2)
    public void ValidateHeader() {

        try {
            WebElement webdriver = webDriver.findElement(By.xpath("//*[@id=\'mainSection\']/ng-view/header/h11"));
            Assert.assertEquals(webdriver.getText(), "ShoppingCart Applications");
        }catch (Exception i) {
            Assert.fail("The error message is " + i);
        }
    }

    @AfterTest
    public void CloseDriver() {
        webDriver.quit();
    }
}
