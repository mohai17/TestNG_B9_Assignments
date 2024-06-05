package TestNG_Assignment01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClassAnnotation {

    WebDriver webDriver;

    @BeforeClass
    public void setupBrowser(){

        webDriver = new FirefoxDriver();
        webDriver.get("https://www.saucedemo.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @AfterClass
    public void closeBrowser(){

        webDriver.close();
    }

}
