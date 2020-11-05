package utilities.parsing.feature;

import io.cucumber.java.Scenario;
import step_definitions.initalStep.POJOScenario;

public class FeatureParsing {

    public static POJOScenario setPOJOScenarios(Scenario scenario){
        return new POJOScenario(scenario);
    }
}
