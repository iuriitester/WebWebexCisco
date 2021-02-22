package com.webexapis.v1.organizations.pojoOrganizationsResponse;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class POJOListOrganization {
    @SerializedName("items")
    public ArrayList<POJOrganization> list;
}
