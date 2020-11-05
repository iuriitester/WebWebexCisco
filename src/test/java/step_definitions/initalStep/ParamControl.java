package step_definitions.initalStep;

// This class is needed for initializing the class's params from property files and the feature scenarios
// feature params have more priority then property params

import com.webexuis.v1._generalApp.Pages;
import io.cucumber.java.Scenario;
import utilities.dictionary.Applications;
import utilities.dictionary.PropertyFiles;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullParamException;
import utilities.generalUtilities.Environment;
import utilities.parsing.feature.FeatureParsing;

public class ParamControl {
    private final POJOScenario pojoScenario;

    public ParamControl(Scenario scenario) {
        String scenarioName = scenario.getName();
         pojoScenario =  FeatureParsing.setPOJOScenarios(scenario);

    }



    public Object getParam(String paramKey) throws NullParamException {
        Applications app=null;


            try {

                // application defining process
                if(pojoScenario.getObject("app")!=null)
                    app = Applications.getApp((String)pojoScenario.getObject("app"));
                else app = Applications.getApp(Environment.getProperty(PropertyFiles.appconfig, "app"));

                // searching the param in the application configuration properties
                if(pojoScenario.getObject(paramKey)!=null) return pojoScenario.getObject(paramKey);
                else
                    switch (app){
                        case admin: return Environment.getProperty(PropertyFiles.admin,paramKey);
                        case develop: return Environment.getProperty(PropertyFiles.develop,paramKey);
                        case person: return Environment.getProperty(PropertyFiles.person,paramKey);
                        case web: return Environment.getProperty(PropertyFiles.web,paramKey);
                    }
            } catch (NullAppException e) {
                e.printStackTrace();
            }

       // searching in other configuration files
       Object env = Environment.getProperty(PropertyFiles.appconfig, paramKey);
            if (env!=null) return env;
       env = Environment.getProperty(PropertyFiles.qa, paramKey);
            if(env!=null) return env;

       // generate Exception if param is not found
       throw new NullParamException("The param " + paramKey + " is NOT defined");
    }
}

