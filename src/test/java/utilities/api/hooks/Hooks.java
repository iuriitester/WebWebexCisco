package utilities.api.hooks;

import io.restassured.RestAssured;
import utilities.api.steps.BaseStepDef;
import utilities.generalUtilities.Environment;
import io.cucumber.java.*;
public class Hooks extends BaseStepDef {

    @Before(order = 10)
    public void setUpScenario(){
        RestAssured.baseURI = Environment.getProperty("base_url");
    }
}
