import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMainClass {
    public static void main (String[] args) {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://google.com");
    }
}
