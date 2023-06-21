package PageObject;

import org.openqa.selenium.By;

public class LogInPage {
    protected By userField = By.id("userName");
    protected By passwordField = By.id("newPass");
    protected By logInButton = By.id("submitAuth");
    protected By alert = By.id("growlText");
}
