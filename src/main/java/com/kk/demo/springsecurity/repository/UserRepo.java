package com.kk.demo.springsecurity.repository;

import com.kk.demo.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
