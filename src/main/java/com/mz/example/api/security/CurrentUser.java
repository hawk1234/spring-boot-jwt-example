package com.mz.example.api.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//Spring security provides an annotation called @AuthenticationPrincipal to access the currently authenticated user in the controllers.
@AuthenticationPrincipal
public @interface CurrentUser {}
