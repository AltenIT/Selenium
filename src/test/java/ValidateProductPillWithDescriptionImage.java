import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidateProductPillWithDescriptionImage {
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

    @Test (priority = 3)
    public void ValidatePillImage() {

        try {
            WebElement button = webDriver.findElement(By.xpath("//div[@id='product_pills']//img"));
            Assert.assertTrue(button.isDisplayed());
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("Failed to find the image " + i);
        }
    }

    @Test (priority = 4)
    public void ValidatePillDescription() {

        try {
            WebElement description = webDriver.findElement(By.xpath("//div[@id='product_pills']//p"));
            Assert.assertEquals(description.getText(), "Multivitamine Plus bevat maar liefst 44 verschillende vitamines.");
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("Failed to find product pill description " + i);
        }
    }

    @Test (priority = 5)
    public void ValidatePillAddButton() {

        try {
            WebElement button = webDriver.findElement(By.xpath("//button[@id='product_pills_toevoegen']"));
            Assert.assertTrue(button.isDisplayed());
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("Failed to find product pill add button" + i);
        }
    }

    @Test (priority = 6)
    public void ValidatePillPrice() {

        try {
            WebElement price = webDriver.findElement(By.xpath("//div[@id='product_pills']/div[contains(text(), '€10.09')]"));
            String priceText = price.getText();
            Assert.assertEquals(priceText, "Prijs: €10.09");
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("Failed to find price for product pill " + i);
        }
    }

    @AfterTest
    public void CloseDriver() {
        webDriver.quit();
    }
}
