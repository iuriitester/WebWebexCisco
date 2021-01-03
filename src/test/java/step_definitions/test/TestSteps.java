package step_definitions.test;

import io.cucumber.java.en.Given;
import org.testng.annotations.Test;
import step_definitions.applications.develop.initialSteps.DevelopBaseSteps;
import step_definitions.initalStep.ParamControl;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullParamException;
import utilities.exeptions.NullUserNameException;
import utilities.generalUtilities.GitControl;

public class TestSteps extends DevelopBaseSteps {


    public TestSteps() throws NullAppException, NullUserNameException, NullParamException {
    }


    @Given("I am connecting to the repository")
    public void iAmConnectingToTheRepository(){

        GitControl.getGithubAgentStart(paramControl);

        GitControl.getConfigEmail(paramControl);

        GitControl.getConfigName(paramControl);

        GitControl.getTestConnection(paramControl);
    }
}
