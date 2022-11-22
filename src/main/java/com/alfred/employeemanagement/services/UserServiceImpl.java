package com.alfred.employeemanagement.services;

import com.alfred.employeemanagement.models.Role;
import com.alfred.employeemanagement.models.User;
import com.alfred.employeemanagement.models.UserRegistrationDto;
import com.alfred.employeemanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {

        User user = new User(registrationDto.getUsername(), registrationDto.getPassword(), Role.USER);
        return userRepository.save(user);
    }
}
