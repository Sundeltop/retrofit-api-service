package org.example.api.service;

import lombok.SneakyThrows;
import org.example.api.UserApi;
import org.example.api.dto.User;
import retrofit2.Response;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.glassfish.grizzly.http.util.HttpStatus.*;

public class UserService extends ApiService {

    private final UserApi api = retrofit.create(UserApi.class);

    @SneakyThrows
    public List<User> getUsers() {
        Response<List<User>> response = api.getUsers(BEARER_TOKEN).execute();
        assertThat(response.code()).isEqualTo(OK_200.getStatusCode());

        return response.body();
    }

    @SneakyThrows
    public User createUser(User user) {
        Response<User> response = api.createUser(BEARER_TOKEN, user).execute();
        assertThat(response.code()).isEqualTo(CREATED_201.getStatusCode());

        return response.body();
    }

    @SneakyThrows
    public void deleteUser(int id) {
        Response<Void> response = api.deleteUser(BEARER_TOKEN, id).execute();
        assertThat(response.code()).isEqualTo(NO_CONTENT_204.getStatusCode());
    }
}
