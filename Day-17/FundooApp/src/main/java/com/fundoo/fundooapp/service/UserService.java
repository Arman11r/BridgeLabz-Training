package com.fundoo.fundooapp.service;

import com.fundoo.fundooapp.dto.AuthResponse;
import com.fundoo.fundooapp.dto.LoginRequest;
import com.fundoo.fundooapp.dto.RegisterRequest;

public interface UserService {
    AuthResponse register(RegisterRequest req);
    AuthResponse login(LoginRequest req);
}