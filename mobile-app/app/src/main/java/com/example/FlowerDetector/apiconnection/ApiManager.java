package com.example.FlowerDetector.apiconnection;

public class ApiManager {
    //public static final String BASE_URL = "http://112.137.129.202:3001/";
    public static final String BASE_URL = "http://192.168.1.17:5000/";
    //public static final String BASE_URL = "http://a8dc9535173b.ngrok.io";

    public static ApiService getApiService() {
        return ApiClient.getClient(BASE_URL).create(ApiService.class);
    }
}