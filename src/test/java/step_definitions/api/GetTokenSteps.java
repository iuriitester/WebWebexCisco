package step_definitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import step_definitions.applications.develop.initialSteps.DevelopBaseSteps;
import utilities.api.APIAuthorization;
import utilities.dictionary.EndPoints;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullParamException;
import utilities.exeptions.NullUserNameException;
import utilities.ui.BrowserUtils;
import utilities.ui.Driver;

import static io.restassured.RestAssured.given;

public class GetTokenSteps extends DevelopBaseSteps {

    public GetTokenSteps() throws NullAppException, NullUserNameException, NullParamException {
    }

    @Given("I am checking Token to take Token")
    public void i_am_checking_Token_to_take_Token() {

        if(APIAuthorization.getToken() != null)
            // checking current Token. Token has 12 hours life, therefore it may be overdue
        Assertions.assertTrue(given().
                header("Authorization", APIAuthorization.getToken()).
                log().all().
                when().
                get(EndPoints.organizations.getEndpoint()).getStatusCode()==401);
        // for reporting. It is always TRUE
        else Assertions.assertTrue(APIAuthorization.getToken() == null);

    }

    @When("I go to TokenPage")
    public void i_go_to_TokenPage() {
        try {
            Driver.getDriver().get((String)paramControl.getParam("token_base_url"));
        } catch (NullParamException e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(developWebexPages.gettingStartedPage.bodyTokenButton.isDisplayed());
    }

    @And("I take Token")
    public void itakeToken() {

        developWebexPages.gettingStartedPage.bodyTokenButton.click();
        BrowserUtils.waitForVisibility(developWebexPages.gettingStartedPage.bodyTokenButton,3);
        developWebexPages.gettingStartedPage.okButton.click();
        APIAuthorization.setToken(BrowserUtils.copyFromBuffer());

    }

}