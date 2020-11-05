package utilities.exeptions;

import utilities.dictionary.Applications;

// this exception is generated if userName is not found in the configuration property files

public class NullUserNameException extends Exception{
    private String userName;

    public NullUserNameException(String message, String userName) {
        super(message);
        this.userName = userName;
    }
}
