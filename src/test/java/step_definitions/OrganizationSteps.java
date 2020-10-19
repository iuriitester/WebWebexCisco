package step_definitions;

import com.webexapis.v1.organizations.root.OrganizationsRoot;
import com.webexapis.v1.organizations.xpojo.POJOrganization;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class OrganizationSteps {

    @Given("organization is not created")
    public void organization_is_not_created(String orgId){

        POJOrganization pojOrganization =  OrganizationsRoot.get(orgId).as(POJOrganization.class);
        System.out.println(pojOrganization.toString());


       // assertThat(pojOrganization.getId(), is)

    }

    @When("I create a new organization")
    public void iCreateANewOrganizationOrg() {
    }

    @Then("I have new organization")
    public void iHaveNewOrganizationOrg() {
    }

    @Given("The API has this organization")
    public void theAPIHasThisOrganizationOrg() {
    }

    @When("I delete this organization")
    public void iDeleteThisOrganizationOrg() {
    }

    @Then("The API has not this organization")
    public void theAPIHasNotThisOrganization() {
    }
}
