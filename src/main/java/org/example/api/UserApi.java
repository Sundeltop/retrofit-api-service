package org.example.api;

import org.example.api.dto.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface UserApi {

    @GET("users")
    Call<List<User>> getUsers(@Header("Authorization") String bearerToken);

    @POST("users")
    Call<User> createUser(@Header("Authorization") String bearerToken,
                          @Body User user);

    @DELETE("users/{id}")
    Call<Void> deleteUser(@Header("Authorization") String bearerToken,
                          @Path("id") int id);
}
