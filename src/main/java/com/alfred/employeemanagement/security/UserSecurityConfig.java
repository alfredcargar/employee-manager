package com.alfred.employeemanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(2)
public class UserSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChainUser(HttpSecurity http) throws Exception{

        http.authorizeRequests().antMatchers("/user/registration").permitAll();

        http.antMatcher("/user/**")
                .authorizeRequests().anyRequest().hasAuthority("USER")
                .and()
                .formLogin()
                    .loginPage("/user/login")
                    .usernameParameter("username")
                    .loginProcessingUrl("/user/login")
                    .defaultSuccessUrl("/user/employees")
                    .permitAll()
                .and()
                .logout()
                    .logoutUrl("/user/logout")
                    .logoutSuccessUrl("/");

        return http.build();
    }
}
