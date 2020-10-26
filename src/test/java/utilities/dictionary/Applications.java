package utilities.dictionary;

public enum Applications {
    ADMIN,
    DEVELOP,
    WEB,
    PERSONAL;

    public static Applications getApp(String app){
        switch (app){
          case "ADMIN": return Applications.ADMIN;
          case "DEVELOP": return Applications.DEVELOP;
          case "WEB": return Applications.WEB;
          case "PERSONAL": return Applications.PERSONAL;
      }
      return null;
    }
}
