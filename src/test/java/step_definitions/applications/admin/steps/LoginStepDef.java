package step_definitions.applications.admin.steps;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import step_definitions.applications.admin.initialSteps.AdminBaseSteps;
import step_definitions.initalStep.BaseStep;
import utilities.dictionary.Applications;
import utilities.dictionary.PropertyFiles;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullParamException;
import utilities.exeptions.NullUserNameException;
import utilities.generalUtilities.Environment;
import utilities.ui.Driver;

public class LoginStepDef extends AdminBaseSteps {

    public LoginStepDef() throws NullAppException, NullUserNameException, NullParamException {
        super();
    }

}
