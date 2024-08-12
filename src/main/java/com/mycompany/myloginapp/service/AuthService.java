package com.mycompany.myloginapp.service;

import com.mycompany.myloginapp.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean authenticate(User user) {
        // Placeholder logic for authentication
        return "admin".equals(user.getUsername()) && "password".equals(user.getPassword());
    }
}

