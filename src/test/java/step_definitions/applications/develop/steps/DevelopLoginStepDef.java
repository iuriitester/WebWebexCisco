package step_definitions.applications.develop.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import step_definitions.applications.develop.initialSteps.DevelopBaseSteps;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullParamException;
import utilities.exeptions.NullUserNameException;
import utilities.ui.Driver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DevelopLoginStepDef extends DevelopBaseSteps {

    public DevelopLoginStepDef() throws NullAppException, NullUserNameException, NullParamException {
    }
    @Test
    @Given("^I am going to ([^\"]*)$")
    public void iAmGoingToApp(String base_url) {

        try {
            Driver.getDriver().get((String)paramControl.getParam("base_url"));
        } catch (NullParamException e) {
            e.printStackTrace();
        }
        Driver.getDriver().manage().window().setSize(new Dimension(1920, 1080));
        Driver.getDriver().manage().window().fullscreen();
        Driver.getDriver().manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        File file = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("D:/JavaProjects/CiscoWebexTestAPI/target/scr.png"));
        }
        catch (IOException ioe){
            System.out.println("It is IO Exception");
        }
        //String screenshotBase64 = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BASE64);
        Assertions.assertTrue(developWebexPages.welcomePage.logIn.isDisplayed());
    }

    @When("^I LogIn as ([^\"]*)$")
    public void iLogInAsUserName(String userName) {

        try {
            pages.getDevelopWebexPages().loginPage.
                    login(
                            (String)paramControl.getParam(userName+".Email"),
                            (String)paramControl.getParam(userName+".Pass")
                    );
        } catch (NullParamException e) {
            e.printStackTrace();
        }
    }

    @Then("I get Welcome Page")
    public void iGetWelcomePage() {
        Assertions.assertTrue(developWebexPages.welcomePage.avatar.isDisplayed());
    }

}
