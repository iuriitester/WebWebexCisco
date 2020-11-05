package utilities.dictionary;

import utilities.exeptions.NullAppException;

// Application Dictionary. Only enum is used in the backend algorithms
// if you add any application, you need to add the according enum element here
// for each application the according property file is defined. You should create according property file and
// to define enum element in the enum ProperyFiles

//*
// for example for admin application it will be view so enum Application.admin.name() == "admin" return Application
// It need only enum is used in the back-end algorithms
// to eliminate string mistakes
//*

public enum Applications {
    admin,
    develop,
    web,
    person;

    public static Applications getApp(String app) throws NullAppException {
        switch (app){
          case "admin": return Applications.admin;
          case "develop": return Applications.develop;
          case "web": return Applications.web;
          case "person": return Applications.person;
            default: throw new NullAppException("Application " + app + " is NOT found", null);
      }
    }
}
