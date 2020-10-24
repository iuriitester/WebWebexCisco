package utilities.generalUtilities;


import utilities.dictionary.PropertyFiles;

public class Authentication {

    private String userName;
    protected String email;
    protected String pass;

    public Authentication(String userName) {
        this.userName = userName;

        this.email = Environment.getProperty(PropertyFiles.APP,userName + "." + "Email");
        this.pass = Encoder.decrypt(Environment.getProperty(PropertyFiles.APP, userName + "." + "Pass"));
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }
}
