package step_definitions.initalStep;


import com.webexuis.v1._generalApp.Pages;
import io.cucumber.java.Scenario;
import utilities.api.APIAuthorization;
import utilities.dictionary.Applications;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullParamException;
import utilities.exeptions.NullUserNameException;
import utilities.generalUtilities.Authentication;

// Based class for all steps classes

public class BaseStep {
    // Scenario for reading params from feature scenarios (extension for Gherkin)
    private static Scenario scenario;
    // class gets param from property files and feature scenarios
    protected ParamControl paramControl;
    // authentication object. It is checking credentials
    protected Authentication authentication;
    // Pages for UI
    protected Pages pages;


    public BaseStep() throws NullAppException, NullUserNameException, NullParamException {

        this.paramControl = new ParamControl(scenario);
        pages = new Pages(Applications.getApp((String)paramControl.getParam("app")));
    }

    public static void setScenario(Scenario scenario) {
        BaseStep.scenario = scenario;
    }

    public Pages getPages() {
        return pages;
    }
}
