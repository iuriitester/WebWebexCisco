package step_definitions.initalStep;


import com.webexuis.v1._generalApp.Pages;
import io.cucumber.java.Scenario;
import utilities.dictionary.Applications;
import utilities.dictionary.PropertyFiles;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullUserNameException;
import utilities.generalUtilities.Authentication;
import utilities.generalUtilities.Environment;

public class BaseStep {
    private static Scenario scenario;
    protected String userName;
    protected final Applications applications;
    protected Authentication authentication;
    protected Pages pages;



/*
    public BaseStep(Applications applications, String userName) {
        this.applications = applications;
        this.authentication = new Authentication(userName);
        this.pages = new Pages(applications);
    }
*/
    public BaseStep() throws NullAppException, NullUserNameException {

        String scenarioName = scenario.getName();
        this.userName = scenarioName.substring(scenarioName.indexOf("*")+1);

        if(Environment.getProperty(PropertyFiles.appconfig, userName + ".Email")==null) throw new NullUserNameException("User is not found", this.userName);
        this.authentication = new Authentication(userName);

        this.applications = Applications.getApp(Environment.getProperty(PropertyFiles.appconfig, "app"));
        if (applications == null) throw new NullAppException("The tested application was not defined", applications);
        this.pages = new Pages(applications);
    }

    public static void setScenario(Scenario scenario) {
        BaseStep.scenario = scenario;
    }

    public String getUserName() {
        return userName;
    }

    public Applications getApplications() {
        return applications;
    }

    public Pages getPages() {
        return pages;
    }
}
