package com.webexapis.v1.organizations.pojoOrganizationsResponse;
import com.google.gson.annotations.SerializedName;

public class POJOrganization {

    @SerializedName("id")
    private String id;

    @SerializedName("displayName")
    private String displayName;

    @SerializedName("created")
    private String created;

    public POJOrganization(){

    }

    public POJOrganization(String id, String displayName, String created) {
        this.id = id;
        this.displayName = displayName;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "POJOrganization{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
