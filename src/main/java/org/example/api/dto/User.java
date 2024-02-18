package org.example.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record User(@JsonProperty("id") int id,
                   @JsonProperty("name") String name,
                   @JsonProperty("email") String email,
                   @JsonProperty("gender") Gender gender,
                   @JsonProperty("status") Status status) {

    public enum Gender {
        @JsonProperty("male") MALE,
        @JsonProperty("female") FEMALE
    }


    public enum Status {
        @JsonProperty("active") ACTIVE,
        @JsonProperty("inactive") INACTIVE
    }
}
