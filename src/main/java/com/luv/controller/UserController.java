package com.luv.controller;

import com.luv.dao.request.PasswordResetRequest;
import com.luv.dao.response.BaseResponse;
import com.luv.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import static com.luv.util.constant.MiscellaneousConstants.API_VERSION;

@RestController
@RequestMapping(API_VERSION + "/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userServiceInstance;

    @PatchMapping("/password-reset")//TODO: Complete Password Reset Flow just after MVP
    public BaseResponse<?> userPasswordReset(
            @RequestBody PasswordResetRequest passwordResetRequestBody,
            Principal connectedUser
    ) {
        userServiceInstance.passwordReset(passwordResetRequestBody, connectedUser);
        return BaseResponse.success();
    }
}
