package service;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UItest extends InitialTest{

    @Test
    public void autorization() {
        System.out.println(driver.toString());
        driver.get("http://localhost:8080/login");
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("us301");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("7130");
        WebElement submit = driver.findElement(By.xpath("//button[@id='send']"));
        submit.sendKeys(Keys.ENTER);
        WebElement targetLabel = driver.findElement(By.xpath("//button[@id='exit']"));
        Assert.assertTrue(targetLabel.isDisplayed());
    }
}
