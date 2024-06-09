package com.luv.dao.request;

import lombok.Data;

@Data
public class SignUpRequest {
    private String email;
    private String rawPassword;
    private String firstname;
    private String lastname;
}
