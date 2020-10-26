package utilities.dictionary;

public enum Applications {
    admin,
    develop,
    web,
    person;

    public static Applications getApp(String app){
        switch (app){
          case "admin": return Applications.admin;
          case "develop": return Applications.develop;
          case "web": return Applications.web;
          case "person": return Applications.person;
      }
      return null;
    }
}
