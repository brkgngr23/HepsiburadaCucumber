package com.hepsiburada.stepdefinitions;

import com.hepsiburada.core.operations.Api;
import io.cucumber.java.en.Given;

public class ApiStepDefinitions {

    String generatorUrl = "https://generator.swagger.io/";
    String petstoreUrl = "https://petstore.swagger.io/";
    String generatorName = "api/gen/clients/ada";
    String petstoreName = "v2/pet";
    String petstoreServiceBody = "{\"id\": 0,\"category\": {\"id\": 0,\"name\": \"string\"},\"name\": \"doggie\",\"photoUrls\": [\"string\"],\"tags\": [{\"id\": 0,\"name\": \"string\"}],\"status\": \"available\"}";

    public ApiStepDefinitions() {
    }

    @Given("getGenClients")
    public void genClients() {
        Api.useGetService(generatorUrl, generatorName, 200);
    }

    @Given("postAddPet")
    public void addPet() {
        Api.usePostService(petstoreUrl, petstoreName, petstoreServiceBody, 200);
    }

}
