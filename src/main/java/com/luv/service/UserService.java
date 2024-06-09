package com.luv.service;

import com.luv.repository.UserRepository;
import com.luv.dao.request.PasswordResetRequest;
import com.luv.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepositoryInstance;
    public boolean isUserPresent(String email) {
        User userObj = userRepositoryInstance
                .findByEmail(email)
                .orElse(null);
        return userObj != null;
    }

    public User getUser(String email) {
        return  userRepositoryInstance.findByEmail(email).orElse(null);
    }

    public void passwordReset(PasswordResetRequest passwordResetRequest, Principal connectedUser) {
    }

}
