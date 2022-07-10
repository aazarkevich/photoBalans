package ui;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.springframework.context.annotation.PropertySource;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

@PropertySource(value = {"classpath:test.properties"})
public class UItest extends InitialTest{
    private String username = PropertiesTest.getProperty("auth.username");
    private String password = PropertiesTest.getProperty("auth.password");

    private void autorization() {
        driver.get("http://localhost:8080/login");
        WebElement user = driver.findElement(By.xpath("//input[@name='username']"));
        user.sendKeys(username);
        WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
        pass.sendKeys(password);
        WebElement submitSend = driver.findElement(By.xpath("//button[@id='send']"));
        submitSend.sendKeys(Keys.ENTER);
    }

    @Test
    public void autorizationTest() {
        autorization();
        WebElement targetButton = driver.findElement(By.xpath("//button[@id='exit']"));
        Assert.assertTrue(targetButton.isDisplayed());
    }

    @Test
    public void findSerialNumber() {
        autorization();
        driver.get("http://localhost:8080/");
        Select selectFind = new Select(driver.findElement(By.xpath("//select[@id='selectFind']")));
        selectFind.selectByValue("serial");
        WebElement find = driver.findElement(By.id("find"));
        find.sendKeys("123");
        WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Поиск')]"));
        submit.sendKeys(Keys.ENTER);
        WebElement targetTd = driver.findElement(By.xpath("//td[@name='beeF1']"));
        Assert.assertTrue(targetTd.isDisplayed());
    }

    @Test
    public void findFio() {
        autorization();
        driver.get("http://localhost:8080/");
        Select selectFind = new Select(driver.findElement(By.xpath("//select[@id='selectFind']")));
        selectFind.selectByValue("fio");
        WebElement find = driver.findElement(By.id("find"));
        find.sendKeys("Артем");
        WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Поиск')]"));
        submit.sendKeys(Keys.ENTER);
        WebElement targetTd = driver.findElement(By.xpath("//td[@name='beeF1']"));
        Assert.assertTrue(targetTd.isDisplayed());
    }

    @Test
    public void findAddress() {
        autorization();
        driver.get("http://localhost:8080/");
        Select selectFind = new Select(driver.findElement(By.xpath("//select[@id='selectFind']")));
        selectFind.selectByValue("address");
        WebElement find = driver.findElement(By.id("find"));
        find.sendKeys("КРАСНОДОНСКАЯ");
        WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Поиск')]"));
        submit.sendKeys(Keys.ENTER);
        WebElement targetTd = driver.findElement(By.xpath("//td[@name='beeF1']"));
        Assert.assertTrue(targetTd.isDisplayed());
    }

    @Test
    public void findPersonalNumber() {
        autorization();
        driver.get("http://localhost:8080/");
        Select selectFind = new Select(driver.findElement(By.xpath("//select[@id='selectFind']")));
        selectFind.selectByValue("personal");
        WebElement find = driver.findElement(By.id("find"));
        find.sendKeys("1234");
        WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Поиск')]"));
        submit.sendKeys(Keys.ENTER);
        WebElement targetTd = driver.findElement(By.xpath("//td[@name='beeF1']"));
        Assert.assertTrue(targetTd.isDisplayed());
    }

    @Test
    public void findTpAndLine() {
        autorization();
        driver.get("http://localhost:8080/");
        Select selectFind = new Select(driver.findElement(By.xpath("//select[@id='selectFind']")));
        selectFind.selectByValue("tpAndLine");
        WebElement find = driver.findElement(By.id("find"));
        find.sendKeys("316");
        WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Поиск')]"));
        submit.sendKeys(Keys.ENTER);
        WebElement targetTd = driver.findElement(By.xpath("//td[@name='beeF1']"));
        Assert.assertTrue(targetTd.isDisplayed());
    }

    @Test
    public void savePhoto() {
        autorization();
        driver.get("http://localhost:8080/find?selectFind=serial&find=123");
        String downloadLink = driver
                .findElement(By.xpath("//a[@name='photo1']"))
                .getAttribute("href");

        File fileToSave = new File("D:\\java\\photoBalans\\src\\main\\test\\ui\\IMG_test.png");
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080" + downloadLink);
        try {
            HttpResponse response = httpClient.execute(httpGet, new BasicHttpContext());
            copyInputStreamToFile(response.getEntity().getContent(), fileToSave);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
