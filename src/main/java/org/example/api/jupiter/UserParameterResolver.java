package org.example.api.jupiter;

import com.github.javafaker.Faker;
import org.example.api.dto.User;
import org.example.api.service.UserService;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.support.AnnotationSupport;

import static org.example.api.dto.User.Gender.MALE;
import static org.example.api.dto.User.Status.ACTIVE;

public class UserParameterResolver implements ParameterResolver {

    private final Faker faker = new Faker();
    private final UserService userService = new UserService();

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().isAssignableFrom(User.class)
                & extensionContext.getRequiredTestMethod().isAnnotationPresent(FakeUser.class);
    }

    @Override
    public User resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        FakeUser fakeUserAnnotation = AnnotationSupport.findAnnotation(extensionContext.getRequiredTestMethod(), FakeUser.class).orElseThrow();

        User user = User.builder()
                .name(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .gender(MALE)
                .status(ACTIVE)
                .build();

        if (fakeUserAnnotation.isCreated()) {
            user = userService.createUser(user);
        }

        return user;
    }
}
