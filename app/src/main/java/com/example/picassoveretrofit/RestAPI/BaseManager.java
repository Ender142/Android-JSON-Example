package com.example.picassoveretrofit.RestAPI;

public class BaseManager {
    protected RestApi getRestApiClient(){
        RestApiClient restApiClient = new RestApiClient(BaseURL.url);
        return restApiClient.getmRestApi();
    }
}
