package com.luv.dao.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String rawPassword;
}
