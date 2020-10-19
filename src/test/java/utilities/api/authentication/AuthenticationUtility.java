package utilities.api.authentication;

import io.restassured.response.Response;
// There is not in the project
public interface AuthenticationUtility {

    Response getLoginResponse();

    String getToken();

    String getRedirectUrl();
}
