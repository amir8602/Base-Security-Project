package com.amir.user;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserModel registerUser(UserModel userFromUi);
}
