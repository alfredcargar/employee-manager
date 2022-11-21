package com.alfred.employeemanagement.security;

import com.alfred.employeemanagement.services.ApplicationUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(1)
public class AdminSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new ApplicationUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/").permitAll();

        http.antMatcher("/admin/**")
                .authorizeRequests().anyRequest().hasAuthority("ADMIN")
                .and()
                .formLogin()
                    .loginPage("/admin/login")
                    .usernameParameter("username")
                    .loginProcessingUrl("/admin/login")
                    .defaultSuccessUrl("/admin/employees")
                    .permitAll()
                .and()
                .logout()
                    .logoutUrl("/admin/logout")
                    .logoutSuccessUrl("/"); // takes you back to home page

        return http.build();
    }
}
