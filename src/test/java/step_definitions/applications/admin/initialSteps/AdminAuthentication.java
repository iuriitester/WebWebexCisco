package step_definitions.applications.admin.initialSteps;

import step_definitions.initalStep.ParamControl;
import utilities.dictionary.Roles;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullParamException;
import utilities.generalUtilities.Authentication;

public class AdminAuthentication extends Authentication {

    public AdminAuthentication(ParamControl paramControl) throws NullAppException, NullParamException {
        super(paramControl);
    }

    @Override
    public void setLog() throws NullAppException, NullParamException {
        this.log = (String)paramControl.getParam(this.userName+".Email");
    }

    @Override
    public void setPass() throws NullAppException, NullParamException {
        this.log = (String)paramControl.getParam(this.userName+".Pass");
    }

    @Override
    public void setRole() throws NullAppException, NullParamException {
        this.role = Roles.getRole((String)paramControl.getParam(this.role+".Role"));
    }
}
