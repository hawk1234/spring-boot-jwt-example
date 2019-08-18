package com.mz.example.api.payload;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private String name;
    private String email;
}
