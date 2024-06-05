package TestNG_Assignment01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SwagLabsDemoTest {

    @Test
    public void checkTitle()
    {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.saucedemo.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        Assert.assertEquals(webDriver.getTitle(),"Swag Labs");

        webDriver.quit();
    }

    @Test
    public void checkCurrentURL(){
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.saucedemo.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.saucedemo.com/");

        webDriver.quit();
    }
    @Test
    public void loginFail(){
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.saucedemo.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        webDriver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("asdfb");
        webDriver.findElement(By.cssSelector("input[id='login-button']")).click();

        int count = webDriver.findElements(By.className("error-message-container")).size();

        Assert.assertEquals(count,1);

        webDriver.quit();

    }

    @Test
    public void loginPass(){
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.saucedemo.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        webDriver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("error_user");
        webDriver.findElement(By.cssSelector("input[id='password']")).sendKeys("secret_sauce");
        webDriver.findElement(By.cssSelector("input[id='login-button']")).click();
        webDriver.findElement(By.id("react-burger-menu-btn")).click();

        int count = webDriver.findElements(By.id("logout_sidebar_link")).size();
//        String logout_text = webDriver.findElement(By.id("logout_sidebar_link")).getText().trim();

        Assert.assertEquals(count,1);
//        Assert.assertEquals(logout_text,"Logout");

        webDriver.quit();
    }

}
