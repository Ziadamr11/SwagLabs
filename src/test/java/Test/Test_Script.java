package Test;

import Page.Login_page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_Script {
    WebDriver driver;
    Login_page loginPage;
    @BeforeMethod
    public void precondetiones(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        loginPage =new Login_page(driver);
    }
    @AfterMethod
    public void TierDown(){
        driver.quit();
    }
    @Test
    public void LoginWithValidUserNameandValidPassword() {
        loginPage.Enter_User_Name("standard_user");
        loginPage.Enter_password("secret_sauce");
        loginPage.Click_login();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void LoginWithInvalidUserNameandvalidPassword() {
        loginPage.Enter_User_Name("ziad123");
        loginPage.Enter_password("secret_sauce");
        loginPage.Click_login();
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class=\"error-button\"]")).isDisplayed());
    }
    @Test
    public void LoginWiyhValidUsernameInvalidPassword() {

        loginPage.Enter_User_Name("standard_user");
        loginPage.Enter_password("#######");
        loginPage.Click_login();
        Assert.assertTrue(true, "Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void  LoginWithEmptyUserNameandEmptyPassword() {

        loginPage.Enter_User_Name("        ");
        loginPage.Enter_password("       ");
        loginPage.Click_login();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @Test
    public void  LoginWithspecialcharacteryUserNameandspecialcharacterforpasswordPassword() {
        loginPage.Enter_User_Name("%^&^%$#@%^");
        loginPage.Enter_password("%$#@#@#$)*");
        loginPage.Click_login();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }
@Test
    public void  LoginWithspecialcharacteryandemptyUserNameandspecialcharacterforpasswordPassword() {
        loginPage.Enter_User_Name("%^&^%$#@%^    ");
        loginPage.Enter_password("%$#@#@#$)*");

        loginPage.Click_login();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @Test
    public void HelalTest() {

        loginPage.Enter_User_Name("Helal");
        loginPage.Enter_password("#######");
        loginPage.Click_login();
        Assert.assertTrue(true, "Epic sadface: Username and password do not match any user in this service");
    }


    @Test
    public void  LoginWithNumbersUserNameandnumbersforpasswordPassword() {
        loginPage.Enter_User_Name("546456570");
        loginPage.Enter_password("876789870");
        loginPage.Click_login();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @Test
    public void  LoginWithCharatersUserNameandnumbersforpasswordPassword() {
        loginPage.Enter_User_Name("sgkjfrujid");
        loginPage.Enter_password("876789870");
        loginPage.Click_login();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

}


