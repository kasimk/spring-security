package com.kk.demo.springsecurity.repository;

import com.kk.demo.springsecurity.model.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSecurityRepo extends JpaRepository<UserSecurity, String> {

    UserSecurity findTopByName(
            String name
    );

}
