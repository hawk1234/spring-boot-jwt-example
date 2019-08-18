package com.mz.example.api.controller;

import com.mz.example.api.exception.ResourceNotFoundException;
import com.mz.example.api.payload.UserResponse;
import com.mz.example.db.entity.User;
import com.mz.example.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(APIRequestMapping.BASE_USER_PATH)
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Secured("ROLE_USER")//TODO: how can I reference role as static field?
    @GetMapping(APIRequestMapping.USER_DATA_METHOD)
    public ResponseEntity<UserResponse> getData(@PathVariable String username){
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("user", "username", username));
        return ResponseEntity.ok(UserResponse.builder().email(user.getEmail()).name(user.getName()).build());
    }
}
