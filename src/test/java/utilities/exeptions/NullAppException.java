package utilities.exeptions;

import utilities.dictionary.Applications;

public class NullAppException extends Exception{
    private Applications app;

    public NullAppException(String message, Applications app) {
        super(message);
        this.app = app;
    }


}
