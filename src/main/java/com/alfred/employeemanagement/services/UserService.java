package com.alfred.employeemanagement.services;

import com.alfred.employeemanagement.security.User;
import com.alfred.employeemanagement.web.dto.UserRegistrationDto;

public interface UserService {

    User save(UserRegistrationDto userRegistrationDto);

}
