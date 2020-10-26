package step_definitions.applications.admin;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import step_definitions.initalStep.BaseStep;
import utilities.dictionary.Applications;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullUserNameException;

public class LoginStepDef extends BaseStep {

    public LoginStepDef() throws NullAppException, NullUserNameException {
        super();
    }

    @Given("^I am going to ([^\"]*)$")
    public void i_am_going_to_admin(String app) {
        System.out.println("Пытаемся запустить приложение " + app);
    }

/*    @When("I am authorizing as {userName} in {app}")
    public void i_am_authorizing_as_irina_kiseleva_in_admin(String userName, String app) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I get something")
    public void i_get_something() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }*/
}
