package com.alfred.employeemanagement.services;

import com.alfred.employeemanagement.models.ApplicationUserDetails;
import com.alfred.employeemanagement.models.User;
import com.alfred.employeemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("The user could not be found in the database.");
        }
        return new ApplicationUserDetails(user);
    }
}
