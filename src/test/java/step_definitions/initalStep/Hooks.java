package step_definitions.initalStep;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import utilities.dictionary.PropertyFiles;
import utilities.exeptions.NullParamException;
import utilities.generalUtilities.Environment;
import utilities.ui.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUpScenario(Scenario scenario) throws NullParamException {
        // the scenario transferring for reading and defining the scenario params
        BaseStep.setScenario(scenario);
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        RestAssured.baseURI = Environment.getProperty(PropertyFiles.admin, "RAbaseURI");
    }
    @After
    public void afterScenario(){
        Driver.getDriver().quit();
        Driver.closeDriver();

    }
}
