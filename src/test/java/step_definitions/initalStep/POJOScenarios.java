package step_definitions.initalStep;

import io.cucumber.java.Scenario;

import java.util.HashMap;
import java.util.List;

public abstract class POJOScenarios {
    // need for keeping of a scenario attributes
    // you can add any string variables for which you can define as Objects in the code

    protected Scenario scenario;

    public POJOScenarios(Scenario scenario) {
        this.scenario = scenario;
    }

    HashMap<String,Object> attributesMap = new HashMap<String,Object>();

    public abstract HashMap<String,Object>  getAttributesMap();
    public abstract List<String> keyList();
    public abstract Object getObject(String key);
}
