package org.example.api;

import lombok.SneakyThrows;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import static org.glassfish.grizzly.http.util.Header.Authorization;

public class AuthInterceptor implements Interceptor {

    private static final String TOKEN = "9a993f2ec2af52ec2a0ae37449ce086658ea389dde95c755b1626fd7def57adc";

    @NotNull
    @Override
    @SneakyThrows
    public Response intercept(@NotNull Chain chain) {
        Request request = chain.request().newBuilder()
                .addHeader(Authorization.toString(), "Bearer %s".formatted(TOKEN))
                .build();

        return chain.proceed(request);
    }
}
