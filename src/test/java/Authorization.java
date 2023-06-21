import StepObject.LogInStep;
import Utils.ChromeRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import static DataObject.LoginData.*;

public class Authorization extends ChromeRunner {
    SoftAssert softAssertion = new SoftAssert();
    LogInStep logInStep =new LogInStep(driver);

    @Test(priority = 1)
    public void logInWithIncorrectData() throws InterruptedException {
        //არასწორი იუზერით და არასწორი პაროლით დალოგინება
        driver.get("https://mycredo.ge/landing/main/auth");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logInStep.userInput(incorrectUserData);
        logInStep.passwordInput(incorrectPasswordData);
        Thread.sleep(1000);
        logInStep.loginButton();
        Thread.sleep(2000);

        String expectedResult = "მონაცემები არასწორი";
        String actualResult = logInStep.getError();

        softAssertion.assertEquals(actualResult,expectedResult);
    }
    @Test(priority = 2)
    public void withEmptyUserDisabledLoginButton() throws InterruptedException {
        //მოწმდება ცარიელი იუზერით და არასწორი პაროლით აქტიურდება თუ არა შესვლის ღილაკი
        driver.get("https://mycredo.ge/landing/main/auth");
        logInStep.userInput(emptyUserData);
        logInStep.passwordInput(incorrectPasswordData);
        Thread.sleep(2000);
        softAssertion.assertFalse(logInStep.loginButtonIsEnabled());
    }
}
