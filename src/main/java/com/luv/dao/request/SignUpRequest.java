package com.luv.dao.request;

import lombok.Data;

@Data
public class SignUpRequest {
    private String email;
    private String rawPassword;
    private String firstName;
    private String lastName;
}
