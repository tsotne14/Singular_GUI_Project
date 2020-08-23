package tests;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class Login{

    WebDriver driver;

    @BeforeTest
    public void setUp()   {
        //Opne URL in browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www-gli.singulardev.uk/");
    }

    @Test
    public void firstTest()  {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        //Login page validation
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'default-theme desktop browser')]")));
        //Username : qa_5
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'user-identifier_')]"))).sendKeys("qa_5");
        //Password : Testing
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'password_')]"))).sendKeys("Testing");
        //Click to login button
        driver.findElement(By.xpath("//*[contains(@type,'submit')]")).click();
        //User page validation via userID and Username
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("userName")));
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@class,'user-id')]")).getText(), "ID: 4837145");
        Assert.assertEquals(driver.findElement(By.id("userName")).getText(), "qa_5");
    }
    @AfterTest
    public void Close()   {
        //Browser close
        driver.close();
    }

}
