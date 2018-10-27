package com.kk.demo.springsecurity.service;

import com.google.common.collect.Lists;
import com.kk.demo.springsecurity.model.UserSecurity;
import com.kk.demo.springsecurity.model.enums.Activation;
import com.kk.demo.springsecurity.repository.UserSecurityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserSecurityRepo repo;

    private final String ADMIN_NAME = "kasim";
    private final String ROLE_USER = "USER";
    private final String ROLE_ADMIN = "ADMIN";

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return Optional.of(userName)
                .map(each -> this.repo.findTopByName(each))
                .filter(each -> {
                    if (Activation.INACTIVE.equals(each.getStatus())) {
                        throw new IllegalStateException(userName + " 用户已經停用");
                    }
                    return true;
                })
                .map(this::transUser)
                .orElseThrow(() -> new IllegalStateException(userName + " 用户不存在！"));
    }

    private User transUser(UserSecurity userEntity) {
        List<SimpleGrantedAuthority> authoritieList = Lists.newArrayList();
        if (this.ADMIN_NAME.equals(userEntity.getName())) {
            authoritieList.add(new SimpleGrantedAuthority(this.ROLE_ADMIN));
        } else {
            authoritieList.add(new SimpleGrantedAuthority(this.ROLE_USER));
        }
        return new User(userEntity.getName(), userEntity.getPassword(), authoritieList);
    }

}
