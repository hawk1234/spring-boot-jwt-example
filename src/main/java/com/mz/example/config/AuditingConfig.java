package com.mz.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
//To enable JPA Auditing, we’ll need to add @EnableJpaAuditing annotation to our main class
// or any other configuration classes.
@EnableJpaAuditing
public class AuditingConfig {
}
