package com.example.authenticationservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.authenticationservice.entities.AppRole;
import com.example.authenticationservice.entities.AppUser;
import com.example.authenticationservice.services.AccountService;

import java.util.ArrayList;

@SpringBootApplication
public class AuthenticationServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthenticationServiceApplication.class, args);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  CommandLineRunner start(AccountService accountService) {
    return args -> {
      accountService.addNewRole(new AppRole(null, "USER"));
      accountService.addNewRole(new AppRole(null, "ADMIN"));
      accountService.addNewRole(new AppRole(null, "AGENT_MANAGER"));
      accountService.addNewRole(new AppRole(null, "AGENT"));

      accountService.addNewUser(new AppUser(null, "user1", "1234", new ArrayList<>()));
      accountService.addNewUser(new AppUser(null, "admin", "1234", new ArrayList<>()));
      accountService.addNewUser(new AppUser(null, "user2", "1234", new ArrayList<>()));
      accountService.addNewUser(new AppUser(null, "user3", "1234", new ArrayList<>()));

      accountService.addRoleToUser("user1", "USER");
      accountService.addRoleToUser("admin", "USER");
      accountService.addRoleToUser("user2", "USER");
      accountService.addRoleToUser("user3", "USER");
      accountService.addRoleToUser("admin", "ADMIN");
      accountService.addRoleToUser("user2", "AGENT_MANAGER");
      accountService.addRoleToUser("user3", "AGENT");
    };
  }
}
