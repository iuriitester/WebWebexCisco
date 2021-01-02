package step_definitions.test;

import io.cucumber.java.en.Given;
import org.testng.annotations.Test;
import utilities.generalUtilities.GitControl;

public class TestSteps {
    @Test
    @Given("I am connecting to the repository")
    public void iAmConnectingToTheRepository(){
        GitControl.getGithubAgentStart();

        GitControl.getConfigEmail();

        GitControl.getConfigName();

        GitControl.getTestConnection();
    }
}
