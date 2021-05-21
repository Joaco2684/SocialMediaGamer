package com.joaquin.socialmediagamer.retrofit;

import com.joaquin.socialmediagamer.models.FCMBody;
import com.joaquin.socialmediagamer.models.FCMResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMApi {

    //Interfaz para realizar la ocnuslta

    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAjXaRAEo:APA91bHkw6aLPiwea3ZssSd49EZqzXmHT22P1zkZzOZUB3lRVFW5TnihFV4Ew49miycwP6RQdUeVyPAhZsL1aFKx0FOnTTzN6K9IKVqbmbnz2hCBeZ4Ru3QAnLf2WqwVTItexWuqK-TM"
    })
    @POST("fcm/send") //Tipo de petición para hacer la conuslta
    Call<FCMResponse> send(@Body FCMBody body);

}
