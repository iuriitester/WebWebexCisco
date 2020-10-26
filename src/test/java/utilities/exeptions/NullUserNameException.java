package utilities.exeptions;

import utilities.dictionary.Applications;

public class NullUserNameException extends Exception{
    private String userName;

    public NullUserNameException(String message, String userName) {
        super(message);
        this.userName = userName;
    }
}
