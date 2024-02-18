package org.example.api;

import org.example.api.dto.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface UserApi {

    @GET("users")
    Call<List<User>> getUsers();

    @POST("users")
    Call<User> createUser(@Body User user);

    @DELETE("users/{id}")
    Call<Void> deleteUser(@Path("id") int id);
}
