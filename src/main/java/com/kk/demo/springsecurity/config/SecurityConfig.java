package com.kk.demo.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String ROLE_USER = "USER";
    private final String ROLE_ADMIN = "ADMIN";

    /**
     * 匹配 "/rest" 及其以下所有路径，都需要 "ROLE_ADMIN" 權限
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/rest/**").hasRole(this.ROLE_ADMIN)
                .and()
                .formLogin()
        ;
    }

    /**
     * 在記憶體中建立一個使用者
     *
     * @return UserDetailsService
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        User.UserBuilder user1 = User.withDefaultPasswordEncoder();
        user1.username("kasim");
        user1.password("test");
        user1.roles(this.ROLE_ADMIN);
        manager.createUser(user1.build());

        User.UserBuilder user2 = User.builder();
        user2.username("test");
        user2.password("test");
        user2.roles(this.ROLE_USER);
        manager.createUser(user2.build());
        return manager;
    }
}