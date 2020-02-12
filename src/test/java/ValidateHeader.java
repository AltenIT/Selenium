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
        webDriver.get("http://www.google.nl");
    }

    @Test (priority = 2)
    public void SearchOn() {

        try {
            WebElement inputField = webDriver.findElement(By.xpath("//input[@title='Zoeken']"));
            Assert.assertTrue(inputField.isDisplayed());
            inputField.sendKeys("Alten Nederland");

            WebElement searchButton = webDriver.findElement(By.xpath("//input[@value='Google zoeken']"));
            searchButton.click();
            Thread.sleep(3000);
        }catch (Exception i) {
            Assert.fail("The error message is " + i);
        }
    }

    @Test (priority = 3)
    public void ValidateAltenNederland() {
        try {
            WebElement searchResult = webDriver.findElement(By.xpath("//h3[text()='Home - ALTEN Netherlands']"));
            Assert.assertEquals(searchResult.getText(), "Home - Alten Netherlands");
            Thread.sleep(1000);
        } catch(Exception i) {
            Assert.fail("The error message is " + i);
        }
    }

    @AfterTest
    public void CloseDriver() {
        webDriver.quit();
    }
}
