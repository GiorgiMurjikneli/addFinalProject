package StepObject;

import PageObject.LogInPage;
import org.openqa.selenium.WebDriver;

public class LogInStep extends LogInPage {
    WebDriver driver;

    public LogInStep(WebDriver driver1){
        driver = driver1;
    }
    public void userInput(String st){
        driver.findElement(userField).sendKeys(st);
    }
    public void passwordInput(String st){
        driver.findElement(passwordField).sendKeys(st);
    }
    public void loginButton(){
        driver.findElement(logInButton).click();
    }
    public String getError(){
        return driver.findElement(alert).getText();
    }
    public boolean loginButtonIsEnabled(){
        return driver.findElement(logInButton).isEnabled();
    }
}
