package step_definitions.applications.develop.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import step_definitions.applications.develop.initialSteps.DevelopBaseSteps;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullParamException;
import utilities.exeptions.NullUserNameException;
import utilities.ui.Driver;

import java.util.concurrent.TimeUnit;

public class DevelopLoginStepDef extends DevelopBaseSteps {

    public DevelopLoginStepDef() throws NullAppException, NullUserNameException, NullParamException {
    }

    @Given("^I am going to ([^\"]*)$")
    public void iAmGoingToApp(String base_url) {

        try {
            Driver.getDriver().get((String)paramControl.getParam("base_url"));
        } catch (NullParamException e) {
            e.printStackTrace();
        }

        Driver.getDriver().manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
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
