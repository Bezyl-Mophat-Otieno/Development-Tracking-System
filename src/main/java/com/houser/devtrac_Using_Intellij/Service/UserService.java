package com.houser.devtrac_Using_Intellij.Service;

import com.houser.devtrac_Using_Intellij.Entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

     List<User> getAllUsers();
     void saveUser(User user);
     User  save(User registrationDto);
     User  getUserById(long id);
     void deleteUserById(long id);
}
