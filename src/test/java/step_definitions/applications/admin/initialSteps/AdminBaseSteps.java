package step_definitions.applications.admin.initialSteps;

import step_definitions.initalStep.BaseStep;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullParamException;
import utilities.exeptions.NullUserNameException;

public class AdminBaseSteps extends BaseStep {

    public AdminBaseSteps() throws NullAppException, NullUserNameException, NullParamException {
        authentication = new AdminAuthentication(paramControl);
    }

}
