package step_definitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import step_definitions.applications.develop.initialSteps.DevelopBaseSteps;
import utilities.api.APIAuthorization;
import utilities.dictionary.DirectoryType;
import utilities.dictionary.EndPoints;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullParamException;
import utilities.exeptions.NullUserNameException;
import utilities.generalUtilities.DeleteDirectory;
import utilities.generalUtilities.GitControl;
import utilities.ui.BrowserUtils;
import utilities.ui.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


import static io.restassured.RestAssured.given;

public class GetTokenSteps extends DevelopBaseSteps {

    public GetTokenSteps() throws NullAppException, NullUserNameException, NullParamException {
    }
    @Test
    @Given("I am checking Token to take Token")
    public void i_am_checking_token_to_take_token() {
        System.out.println("Just simple test!!!");
        if(APIAuthorization.getToken() != null)
            // checking current Token. Token has 12 hours life, therefore it may be overdue
            Assertions.assertEquals(given().
                    header("Authorization", APIAuthorization.getToken()).
                    log().all().
                    when().
                    get(EndPoints.organizations.getEndpoint()).getStatusCode(), 401);
        // for reporting. It is always TRUE
        else Assertions.assertNull(APIAuthorization.getToken());

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
    public void itakeToken()  {
        developWebexPages.gettingStartedPage.bodyTokenButton.click();
        BrowserUtils.waitForVisibility(developWebexPages.gettingStartedPage.bodyTokenButton,3);
        developWebexPages.gettingStartedPage.okButton.click();
     //   APIAuthorization.setToken(BrowserUtils.copyFromBuffer());
        //Assertions.assertFalse(APIAuthorization.getToken().isEmpty());
    }

    @And("I save it to the file")
    public void i_save_it_to_the_file() throws IOException {

        File directory = new File(String.valueOf(GitControl.getDirectory(paramControl, DirectoryType.directory)));

        if (directory.exists())
            try{

                DeleteDirectory.delete(directory);

            }catch(IOException e){
                e.printStackTrace();
                System.exit(0);
            }

        Files.createDirectories(GitControl.getDirectory(paramControl, DirectoryType.directory));
        Files.write(GitControl.getDirectory(paramControl, DirectoryType.directory).resolve("token.txt"), BrowserUtils.copyFromBuffer().getBytes());
    }

    @And("Push to the remote repository")
    public void push_to_the_remote_repository(){
        GitControl.getConfigEmail(paramControl);

        GitControl.getConfigName(paramControl);

        GitControl.getInitToken(paramControl);

        GitControl.gitRemoteAddRepo(paramControl);

        GitControl.gitSetRepo(paramControl);

        GitControl.addToken(paramControl);

        GitControl.commitToken(paramControl, "next commit of token key");

        GitControl.pushForceToken(paramControl);


    }
}



