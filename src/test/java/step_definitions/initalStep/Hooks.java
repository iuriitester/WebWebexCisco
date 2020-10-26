package step_definitions.initalStep;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullUserNameException;
import utilities.ui.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUpScenario(Scenario scenario)  {
        BaseStep.setScenario(scenario);
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
