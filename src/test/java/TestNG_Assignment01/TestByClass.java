package TestNG_Assignment01;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestByClass extends BaseClassAnnotation{



    @Test(priority = 1)
    public void checkTitle()
    {

        Assert.assertEquals(webDriver.getTitle(),"Swag Labs");

    }

    @Test
    public void checkCurrentURL(){

        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.saucedemo.com/");

    }
    @Test(priority = 3)
    public void loginFail(){

        webDriver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("asdfb");
        webDriver.findElement(By.cssSelector("input[id='login-button']")).click();

        int count = webDriver.findElements(By.className("error-message-container")).size();

        Assert.assertEquals(count,1);


    }

    @Test(priority = 2)
    public void loginPass() {

        webDriver.navigate().refresh();
        webDriver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("error_user");
        webDriver.findElement(By.cssSelector("input[id='password']")).sendKeys("secret_sauce");
        webDriver.findElement(By.cssSelector("input[id='login-button']")).click();
        webDriver.findElement(By.id("react-burger-menu-btn")).click();


        int count = webDriver.findElements(By.id("logout_sidebar_link")).size();
//        String logout_text = webDriver.findElement(By.id("logout_sidebar_link")).getText().trim();

        Assert.assertEquals(count, 1);
//        Assert.assertEquals(logout_text,"Logout");

        //As the loginPass has priority=2 and loginFail has priority=3, so we have to logout.
        webDriver.findElement(By.id("logout_sidebar_link")).click();

    }


}