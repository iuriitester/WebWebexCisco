package utilities.api.steps;

import utilities.api.authentication.AdminAuthenticationUtility;

public class BaseStepDef {

    protected static String token;

    public BaseStepDef() {
        token = AdminAuthenticationUtility.getToken();
    }
}
