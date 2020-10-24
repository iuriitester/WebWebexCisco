package utilities.generalUtilities;

public class ApiAuthentication extends Authentication{

    private String token;

    public ApiAuthentication(String userName) {
        super(userName);
    }
/*
    public String getToken() {
        if (token == null) {
            //    token = getLoginResponse().jsonPath().getString("token");
        }
        return token;
    }*/

}
