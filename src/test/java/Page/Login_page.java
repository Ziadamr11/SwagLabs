package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_page {

    WebDriver driver;
    By User_Name_Input1 = By.id("user-name");
    By Password_Input2 = By.id("password");
    By Login_button1 = By.id("login-button");

    public Login_page(WebDriver driver){
        this.driver=driver;
    }
    public void Enter_User_Name( String username){
        driver.findElement(User_Name_Input1).sendKeys(username);
    }
    public void Enter_password(String password){
        driver.findElement(Password_Input2).sendKeys(password);
    }
    public void Click_login(){
        driver.findElement(Login_button1).click();
    }
}
