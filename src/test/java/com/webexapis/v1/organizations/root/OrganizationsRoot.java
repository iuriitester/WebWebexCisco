package com.webexapis.v1.organizations.root;

import io.restassured.response.Response;
import utilities.api.steps.BaseStepDef;

import static io.restassured.RestAssured.given;

public class OrganizationsRoot extends BaseStepDef {

    public static Response get(){
        return given().
                header("Authorization:", token).
                when().
                get();

    }

    public static Response get(String orgId){
        return given().
                header("Authorization:", token).
                param("orgId", orgId).
                when().
                get();
    }
}
