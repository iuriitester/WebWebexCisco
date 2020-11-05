package utilities.dictionary;

public enum EndPoints {

    organizations("/organizations"),
    organizationsID("/organizations/{id}");

    String endpoint;

    EndPoints(String endpoint){
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}

