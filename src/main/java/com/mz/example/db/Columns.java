package com.mz.example.db;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Columns {

    //COMMON
    public final String ID = "ID";
    public final String NAME = "NAME";
    public final String CREATED_AT = "CREATED_AT";
    public final String UPDATED_AT = "UPDATED_AT";

    //USER
    public final String USERNAME = "USERNAME";
    public final String EMAIL = "EMAIL";
    public final String PASSWORD = "PASSWORD";
    public final String ROLE_ID = "ROLE_ID";

    //USER_ROLE
    public final String USER_ID = "USER_ID";
}
