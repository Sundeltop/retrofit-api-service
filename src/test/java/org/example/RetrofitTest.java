package org.example;

import org.example.api.dto.User;
import org.example.api.jupiter.FakeUser;
import org.example.api.service.UserService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RetrofitTest {

    private final UserService userService = new UserService();

    @Test
    @FakeUser(isCreated = false)
    void verifyCreateUser(User user) {
        User userResponse = userService.createUser(user);

        assertThat(userResponse)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(user);
    }

    @Test
    @FakeUser
    void verifyGetUsers(User user) {
        List<User> users = userService.getUsers();

        assertThat(users)
                .isNotEmpty()
                .contains(user);
    }

    @Test
    @FakeUser
    void verifyDeleteUser(User user) {
        userService.deleteUser(user.id());
        List<User> users = userService.getUsers();

        assertThat(users).doesNotContain(user);
    }
}