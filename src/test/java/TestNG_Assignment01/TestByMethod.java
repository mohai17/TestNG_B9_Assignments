package TestNG_Assignment01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestByMethod {

    WebDriver webDriver;

    @BeforeMethod
    public void setupBrowser(){

        webDriver = new FirefoxDriver();
        webDriver.get("https://www.saucedemo.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test
    public void checkTitle()
    {

        Assert.assertEquals(webDriver.getTitle(),"Swag Labs");

    }

    @Test
    public void checkCurrentURL(){

        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.saucedemo.com/");

    }
    @Test
    public void loginFail(){

        webDriver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("asdfb");
        webDriver.findElement(By.cssSelector("input[id='login-button']")).click();

        int count = webDriver.findElements(By.className("error-message-container")).size();

        Assert.assertEquals(count,1);


    }

    @Test
    public void loginPass() {

        webDriver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("error_user");
        webDriver.findElement(By.cssSelector("input[id='password']")).sendKeys("secret_sauce");
        webDriver.findElement(By.cssSelector("input[id='login-button']")).click();
        webDriver.findElement(By.id("react-burger-menu-btn")).click();

        int count = webDriver.findElements(By.id("logout_sidebar_link")).size();
//        String logout_text = webDriver.findElement(By.id("logout_sidebar_link")).getText().trim();

        Assert.assertEquals(count, 1);
//        Assert.assertEquals(logout_text,"Logout");

    }

    @AfterMethod
    public void closeBrowser(){

        webDriver.close();
    }

}