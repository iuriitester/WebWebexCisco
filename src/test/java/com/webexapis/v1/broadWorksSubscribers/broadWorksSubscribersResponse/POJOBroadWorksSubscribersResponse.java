package com.webexapis.v1.broadWorksSubscribers.broadWorksSubscribersResponse;
import com.google.gson.annotations.SerializedName;

public class POJOBroadWorksSubscribersResponse {

    @SerializedName("Id")
    private String id;

    @SerializedName("PersonId")
    private String personId;

    @SerializedName("userId")
    private String userId;

    @SerializedName("spEnterpriseId")
    private String spEnterpriseId;

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName")
    private String lastName;

    @SerializedName("email")
    private String email;

    @SerializedName("language")
    private String language;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getUserId() {
        return userId;
    }

    public String getSpEnterpriseId() {
        return spEnterpriseId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getLanguage() {
        return language;
    }
}
