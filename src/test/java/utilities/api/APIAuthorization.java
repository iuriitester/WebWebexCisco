package utilities.api;

// class for API authentication
// token is here

public class APIAuthorization {

    private static String token = null;

    public static String getToken() {

        return token;
    }

    public static void setToken(String token) {
        APIAuthorization.token = token;
    }

}
