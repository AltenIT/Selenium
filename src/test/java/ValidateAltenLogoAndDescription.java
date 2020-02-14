import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidateAltenLogoAndDescription {
    WebDriver webDriver;

    @BeforeClass
    public void SetUp() {
        webDriver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void VisitShoppingcart() {
        webDriver.get("http://localhost:8090/shoppingcart/#/home");
    }

    @Test (priority = 2)
    public void ValidateAltenLogo() {

        try {
            WebElement inputField = webDriver.findElement(By.xpath("//img[@src='resources/img/Alt1.png']"));
            Assert.assertTrue(inputField.isDisplayed());
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("Failed to find Alten Logo " + i);
        }
    }

    @Test (priority = 3)
    public void ValidateDescription() {

        try {
            WebElement inputField = webDriver.findElement(By.xpath("//h1[text()='ShoppingCart Application']"));
            Assert.assertEquals(inputField.getText(), "ShoppingCart Application");
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("Failed to find the description " + i);
        }
    }

    @AfterTest
    public void CloseDriver() {
        webDriver.quit();
    }
}
