package utilities.dictionary;

import utilities.exeptions.NullAppException;

// Role Dictionary. Only enum is used in the backend algorithms

public enum Roles {
    admin,
    keyuser,
    user;
    public static Roles getRole(String role) throws NullAppException {
        switch (role){
            case "admin": return Roles.admin;
            case "keyuser": return Roles.keyuser;
            case "user": return Roles.user;
            default: throw new NullAppException("Role " + role + " is NOT found", null);
        }
    }
}
