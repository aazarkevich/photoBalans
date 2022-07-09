package service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class InitialTest {
    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.out.println("start");
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","D:\\java\\photoBalans\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
