package com.example.FlowerDetector.apiconnection;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    @GET("getPublicKey")
        /*imgBytes*/
    Call<FlowerDetectionResponse> getDetectionResult();

    @Multipart
    @POST("flowerRecognition")
    Call<FlowerDetectionResponse> getDetectionResult(@Part MultipartBody.Part part);

    @POST("flowerRecognition")
    Call<FlowerDetectionResponse> getDetectionResult(@Body String base64Image);
}