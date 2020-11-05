package utilities.exeptions;

import utilities.dictionary.Applications;

// If string app param is not found in Application enum then this exception is appeared
 // for example for admin application it will be view so enum Application.admin.name() == "admin" return Application
// It need only enum is used in the back-end algorithms
// to eliminate string mistakes

public class NullAppException extends Exception{
    private Applications app;

    public NullAppException(String message, Applications app) {
        super(message);
        this.app = app;
    }
}
