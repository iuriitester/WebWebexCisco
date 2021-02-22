package com.webexapis.v1.broadWorksSubscribers.broadWorksSubscribersResponse;

import com.google.gson.annotations.SerializedName;
import com.webexapis.v1.organizations.pojoOrganizationsResponse.POJOrganization;

import java.util.ArrayList;

public class POJOListBroadWorksSubscribersRequests {
    @SerializedName("items")
    public ArrayList<POJOBroadWorksSubscribersResponse> list;
}
