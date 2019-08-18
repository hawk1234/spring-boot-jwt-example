package com.mz.example.api.controller;

import lombok.experimental.UtilityClass;

@UtilityClass
public class APIRequestMapping {

    public static final String BASE_PATH = "/api/";
    public static final String BASE_AUTH_PATH = BASE_PATH+"auth/";
    public static final String BASE_USER_PATH = BASE_PATH+"user/";
    public static final String BASE_ADMIN_PATH = BASE_PATH+"admin/";

    public static final String AUTH_SIGN_IN_METHOD = BASE_AUTH_PATH + "signin";
    public static final String AUTH_SIGN_UP_METHOD = BASE_AUTH_PATH + "signup";

    public static final String USER_DATA_METHOD = BASE_ADMIN_PATH + "{username}";

    public static final String ADMIN_USERS_METHOD = BASE_ADMIN_PATH + "users";
}
