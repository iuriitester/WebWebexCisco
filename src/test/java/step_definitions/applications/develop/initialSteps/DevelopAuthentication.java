package step_definitions.applications.develop.initialSteps;

import step_definitions.initalStep.ParamControl;
import utilities.dictionary.Roles;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullParamException;
import utilities.generalUtilities.Authentication;

public class DevelopAuthentication extends Authentication {

    public DevelopAuthentication(ParamControl paramControl) throws NullAppException, NullParamException {
        super(paramControl);
    }

    @Override
    public void setLog() {
        try {
            this.log = (String)paramControl.getParam(this.userName+".Email");
        } catch (NullParamException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setPass() {
        try {
            this.pass = (String)paramControl.getParam(this.userName+".Email");
        } catch (NullParamException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setRole(){
        try {
            this.role = Roles.getRole((String)paramControl.getParam(this.role+".Role"));
        } catch (NullParamException | NullAppException e) {
            e.printStackTrace();
        }
    }
}
