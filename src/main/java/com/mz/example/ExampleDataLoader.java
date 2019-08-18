package com.mz.example;

import com.mz.example.db.RoleName;
import com.mz.example.db.entity.Role;
import com.mz.example.db.repository.RoleRepository;
import com.mz.example.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Profile("test-app")
public class ExampleDataLoader implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        loadRoles();
    }

    private void loadRoles(){
        Role userRole = new Role();
        userRole.setName(RoleName.ROLE_USER);
        Role adminRole = new Role();
        adminRole.setName(RoleName.ROLE_ADMIN);
        roleRepository.saveAll(Arrays.asList(userRole, adminRole));
    }
}
