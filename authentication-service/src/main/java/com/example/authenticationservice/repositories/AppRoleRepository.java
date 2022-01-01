package com.example.authenticationservice.repositories;

import com.example.authenticationservice.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
  AppRole findByRoleName(String roleName);
}
