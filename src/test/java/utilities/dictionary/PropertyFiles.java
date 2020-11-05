package utilities.dictionary;

// Property Dictionary. Only enum is used in the backend algorithms
 // for example a file is String file = ProperyFiles.EnumElement.name() + "." + properties
// it is used for getting a key's value in the property files
// if you add any property file, you need to add the according enum element here

public enum PropertyFiles {
    configuration,
    qa,
    appconfig,
    develop,
    web,
    admin,
    person;
}
