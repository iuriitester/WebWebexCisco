package utilities.generalUtilities;


import utilities.dictionary.PropertyFiles;

public class Authentication {

    private static String userName;
    private static String email;
    private static String pass;

    public Authentication(String userName) {
        Authentication.userName = userName;

        Authentication.email = Environment.getProperty(PropertyFiles.appconfig,userName + "." + "Email");
        //Authentication.pass = Encoder.decrypt(Environment.getProperty(PropertyFiles.appconfig, userName + "." + "Pass"));
        Authentication.pass = Environment.getProperty(PropertyFiles.appconfig, userName + "." + "Pass");

    }

    public void setUserName(String userName) {
        Authentication.userName = userName;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPass() {
        return pass;
    }

}
