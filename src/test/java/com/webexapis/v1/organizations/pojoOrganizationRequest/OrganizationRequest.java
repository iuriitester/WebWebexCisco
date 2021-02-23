package com.webexapis.v1.organizations.pojoOrganizationRequest;

import com.webexapis.v1.organizations.pojoOrganizationsResponse.POJOrganization;

import java.util.ArrayList;

public class OrganizationRequest{

    private  POJOrganization pojOrganization;
    private  ArrayList<POJOrganization> listPojOrganization;
    private int responseCode;

    private OrganizationParam organizationParam;

    public OrganizationRequest(String orgId) {
        this.organizationParam = new OrganizationParam(orgId);
    }

    public void getOrganization(){
        // API Request
        // API Response is serialized to POJOrganization instance
        // after pojOrganization = the created instance

        pojOrganization = new POJOrganization();
    }

    public void getListOrganization(){
        // заполнить лист объектами, которые получены по запросу getList
    }
}

class OrganizationParam {

    private String orgId;

    public OrganizationParam(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgId() {
        return orgId;
    }
}