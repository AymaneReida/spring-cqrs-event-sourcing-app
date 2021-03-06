package com.example.authenticationservice.services;

import com.example.authenticationservice.entities.AppRole;
import com.example.authenticationservice.entities.AppUser;

import java.util.List;

public interface AccountService {
  AppUser addNewUser(AppUser appUser);

  AppRole addNewRole(AppRole appRole);

  void addRoleToUser(String username, String roleName);

  AppUser loadUserByUsername(String username);

  List<AppUser> listUsers();
}
