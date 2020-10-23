package utilities.api.steps;

import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Assertions;
import utilities.api.authentication.AdminAuthenticationUtility;

public class BaseStepDef {

    protected static String token;

    public BaseStepDef() {
        token = AdminAuthenticationUtility.getToken();
    }
}
