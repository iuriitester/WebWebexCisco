package utilities.api.authentication;

import io.restassured.response.Response;
import utilities.generalUtilities.Encoder;
import utilities.generalUtilities.Environment;

public class AdminAuthenticationUtility  {

    private static String token;

    public static String getToken() {
        if (token == null) {
            token = Environment.getProperty("token");
           // token = getLoginResponse().jsonPath().getString("token");
        }
        return token;
    }

}
