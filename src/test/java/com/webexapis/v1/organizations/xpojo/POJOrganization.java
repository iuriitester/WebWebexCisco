package com.webexapis.v1.organizations.xpojo;
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



}
