package com.alfred.employeemanagement.services;

import com.alfred.employeemanagement.models.User;
import com.alfred.employeemanagement.models.UserRegistrationDto;

public interface UserService {

    User save(UserRegistrationDto userRegistrationDto);
}
