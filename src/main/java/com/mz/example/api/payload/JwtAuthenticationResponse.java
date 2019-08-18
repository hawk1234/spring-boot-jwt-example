package com.mz.example.api.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthenticationResponse {

    private String accessToken;
    private String tokenType = "Bearer";//TODO: why we have this string?

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
