package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_page {

    WebDriver driver;
    By User_Name_Input = By.id("user-name");
    By Password_Input = By.id("password");
    By Login_button = By.id("login-button");

    public Login_page(WebDriver driver){
        this.driver=driver;
    }
    public void Enter_User_Name( String username){
        driver.findElement(User_Name_Input).sendKeys(username);
    }
    public void Enter_password(String password){
        driver.findElement(Password_Input).sendKeys(password);
    }
    public void Click_login(){
        driver.findElement(Login_button).click();
    }
}
