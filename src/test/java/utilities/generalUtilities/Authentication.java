package utilities.generalUtilities;


import step_definitions.initalStep.ParamControl;
import utilities.api.APIAuthorization;
import utilities.dictionary.Roles;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullParamException;

// Pattern for application authentication classes

public abstract class Authentication {
    protected ParamControl paramControl;
    protected String token;
     protected String userName;
     protected String log;
     protected String pass;
     protected Roles role;

    public abstract void setLog() throws NullAppException, NullParamException;
    public abstract void setPass() throws NullAppException, NullParamException;
    public abstract void setRole() throws NullAppException, NullParamException;

    // authentication base class
    // this class contains ParamControl object for defining application params
    // also userName because it is mandatory param for any application
    // All authentication params which relevant for all application are defined here

    public Authentication(ParamControl paramControl) throws NullAppException, NullParamException {

        this.paramControl = paramControl;
        this.userName = (String)paramControl.getParam("userName");
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPass() {
        return this.pass;
    }

    public String getLog() {
        return log;
    }

}
