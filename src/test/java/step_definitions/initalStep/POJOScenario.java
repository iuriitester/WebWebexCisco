package step_definitions.initalStep;

import io.cucumber.java.Scenario;

import java.util.HashMap;
import java.util.List;

public class POJOScenario extends POJOScenarios{


    public POJOScenario(Scenario scenario) {
        super(scenario);
        scenarioStringParsing(this.scenario);

    }

    @Override
    public HashMap<String, Object> getAttributesMap() {
        return attributesMap;
    }

    @Override
    public List<String> keyList() {
        return null;
    }

    @Override
    public Object getObject(String key) {
        return attributesMap.get(key);
    }

    private void scenarioStringParsing(Scenario scenario){
        // Scenario Outline: Scenario *scenario'authorize' attributes *user'<user>' *app'<app>'
        // see zHelp.feature.txt

        String param, value, scenarioName = scenario.getName();
        int beginTempSymbolIndex = 0, endTempSymbolIndex = 0;

        while(scenarioName.contains("*")){
            param = scenarioName.substring(scenarioName.indexOf("*")+1, endTempSymbolIndex = scenarioName.indexOf("'"));
            scenarioName = scenarioName.substring(beginTempSymbolIndex = endTempSymbolIndex+1);
            value = scenarioName.substring(0, endTempSymbolIndex = scenarioName.indexOf("'"));
            scenarioName = scenarioName.substring(endTempSymbolIndex+1);
            attributesMap.put(param,value);
            beginTempSymbolIndex = endTempSymbolIndex = 0;
        }

    }

}
