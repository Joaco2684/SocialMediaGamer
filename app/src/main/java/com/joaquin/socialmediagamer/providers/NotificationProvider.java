package com.joaquin.socialmediagamer.providers;

import com.joaquin.socialmediagamer.models.FCMBody;
import com.joaquin.socialmediagamer.models.FCMResponse;
import com.joaquin.socialmediagamer.retrofit.IFCMApi;
import com.joaquin.socialmediagamer.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Retrofit;

public class NotificationProvider {

    private String url = "https://fcm.googleapis.com";

    public NotificationProvider() {

    }

    public Call<FCMResponse> sendNotification(FCMBody body) {
        return RetrofitClient.getClient(url).create(IFCMApi.class).send(body);
    }

}
