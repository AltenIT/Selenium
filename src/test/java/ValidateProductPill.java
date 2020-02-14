import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidateProductPill {
    WebDriver webDriver;

    @BeforeClass
    public void SetUp() {
        webDriver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void VisitShoppingcart() {
        webDriver.get("http://localhost:8090/shoppingcart/#/shop");
    }

    @Test (priority = 2)
    public void ValidatePill() {

        try {
            WebElement button = webDriver.findElement(By.xpath("//div[@class='card'][1]//h4[contains(text(), 'Pill')]"));
            Assert.assertTrue(button.isDisplayed());
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("Failed to find product pill " + i);
        }
    }

    @AfterTest
    public void CloseDriver() {
        webDriver.quit();
    }
}
