package utilities.api;

// class for API authentication
// token is here

public class APIAuthorization {

    private static String token;

    public static String getToken() {

        return APIAuthorization.token;
    }

    public static void setToken(String token) {
        APIAuthorization.token = token;
    }

}
