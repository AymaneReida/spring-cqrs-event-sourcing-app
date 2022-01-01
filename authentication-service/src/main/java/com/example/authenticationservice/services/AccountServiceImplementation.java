package com.example.authenticationservice.services;

import com.example.authenticationservice.entities.AppRole;
import com.example.authenticationservice.entities.AppUser;
import com.example.authenticationservice.repositories.AppRoleRepository;
import com.example.authenticationservice.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImplementation implements AccountService {
  private final AppUserRepository appUserRepository;
  private final AppRoleRepository appRoleRepository;
  private final PasswordEncoder passwordEncoder;

  public AccountServiceImplementation(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository,
                                      PasswordEncoder passwordEncoder) {
    this.appUserRepository = appUserRepository;
    this.appRoleRepository = appRoleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public AppUser addNewUser(AppUser appUser) {
    appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
    return appUserRepository.save(appUser);
  }

  @Override
  public AppRole addNewRole(AppRole appRole) {
    return appRoleRepository.save(appRole);
  }

  @Override
  public void addRoleToUser(String username, String roleName) {
    AppUser appUser = appUserRepository.findByUsername(username);
    AppRole appRole = appRoleRepository.findByRoleName(roleName);
    appUser.getAppRoles().add(appRole);
  }

  @Override
  public AppUser loadUserByUsername(String username) {
    return appUserRepository.findByUsername(username);
  }

  @Override
  public List<AppUser> listUsers() {
    return appUserRepository.findAll();
  }
}
