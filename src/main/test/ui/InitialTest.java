package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class InitialTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.out.println("start");
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","D:\\java\\photoBalans\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
    }



    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
