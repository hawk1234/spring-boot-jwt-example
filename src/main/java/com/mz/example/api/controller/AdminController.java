package com.mz.example.api.controller;

import com.mz.example.api.payload.UserResponse;
import com.mz.example.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(APIRequestMapping.BASE_ADMIN_PATH)
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Secured("ROLE_ADMIN")//TODO: how can I reference role as static field?
    @GetMapping(APIRequestMapping.USER_DATA_METHOD)
    public ResponseEntity<List<UserResponse>> getData(@PathVariable String username){
        return ResponseEntity.ok(userRepository.findAll().stream().map(user ->
                UserResponse.builder().email(user.getEmail()).name(user.getName()).build()).collect(Collectors.toList()));
    }
}
