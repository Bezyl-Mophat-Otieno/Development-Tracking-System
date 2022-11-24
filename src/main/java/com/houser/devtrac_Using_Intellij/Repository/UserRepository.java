package com.houser.devtrac_Using_Intellij.Repository;

import com.houser.devtrac_Using_Intellij.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserLogon(String username);
}
