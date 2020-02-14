import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class OrderAndDeleteProductPill {
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
            WebElement button = webDriver.findElement(By.xpath("//div[@id='product_pills']"));
            Assert.assertTrue(button.isDisplayed());
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("Failed to find product pill " + i);
        }
    }

    @Test (priority = 3)
    public void AddProductPill() {

        try {
            WebElement button = webDriver.findElement(By.xpath("//button[@id='product_pills_toevoegen']"));
            Assert.assertTrue(button.isDisplayed());
            button.click();
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("Failed to find product pill add button" + i);
        }
    }

    @Test (priority = 4)
    public void ValidatePopup() {

        try {
            WebElement button = webDriver.findElement(By.xpath("//span[@id='productSpan'][text()='1 Geïmporteerde Pill ter waarde van 10.09']"));
            Assert.assertTrue(button.isDisplayed());
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("Failed: the product pill is not added " + i);
        }
    }

    @Test (priority = 5)
    public void ClickRapport() {

        try {
            WebElement button = webDriver.findElement(By.xpath("//a[@href='#/report']"));
            button.click();
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("Failed to click rapport page " + i);
        }
    }

    @Test (priority = 6)
    public void ValidateImportedProductPill() {

        try {
            WebElement productPill = webDriver.findElement(By.xpath("//td[@class='ng-binding'][text()='imported pills']"));
            Assert.assertTrue(productPill.isDisplayed());
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("Failed to validate the imported product pill " + i);
        }
    }

    @Test (priority = 7)
    public void ValidateTotalPrijs() {

        try {
            WebElement totalPrijs = webDriver.findElement(By.xpath("//span[@id='TotaalprijsID']"));
            Assert.assertEquals(totalPrijs.getText(), "Totaal prijs: 10.64");
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("Failed to validate the total price " + i);
        }
    }

    @Test (priority = 8)
    public void DeleteProductPill() {

        try {
            WebElement deleteProduct = webDriver.findElement(By.xpath("//img[@src='resources/img/bin.png']"));
            deleteProduct.click();
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("Failed to delete the product " + i);
        }
    }

    @Test (priority = 9)
    public void ValidateProductPill() {
        List<WebElement> productPill = webDriver.findElements(By.xpath("//td[@class='ng-binding'][text()='imported pills']"));

            if (productPill.size() > 0) {
                Assert.fail("The product pill is still visible");
            }
    }

    @Test (priority = 10)
    public void ValidateTotalPrice() {
        try {
            WebElement totalPrijs = webDriver.findElement(By.xpath("//span[@id='TotaalprijsID']"));
            Assert.assertEquals(totalPrijs.getText(), "Totaal prijs: 0.00");
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("The total price does not match with the expected result " + i);
        }
    }

    @AfterTest
    public void CloseDriver() {
        webDriver.quit();
    }
}
