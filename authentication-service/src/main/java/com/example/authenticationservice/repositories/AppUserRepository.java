package com.example.authenticationservice.repositories;

import com.example.authenticationservice.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
  AppUser findByUsername(String username);
}
