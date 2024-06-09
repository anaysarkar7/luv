package com.luv.controller;

import com.luv.dao.request.SignUpRequest;
import com.luv.dao.request.LoginRequest;
import com.luv.dao.response.BaseResponse;
import com.luv.dao.response.LoginResponse;
import com.luv.dao.response.SignUpResponse;
import com.luv.service.auth.AuthService;
import com.luv.service.auth.LogoutService;
import com.luv.util.exception.AuthException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.luv.util.constant.MiscellaneousConstants.API_VERSION;

@Slf4j
@RestController
@RequestMapping(API_VERSION + "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final LogoutService logoutService;

    @PostMapping("/signup")
    public BaseResponse<Object> signup(
            @RequestBody @Validated SignUpRequest signUpRequestBody
    ) {
        try {
            SignUpResponse signUpResponse = authService.signUp(signUpRequestBody);
            return BaseResponse.success(signUpResponse);
        } catch (AuthException e) {
            log.error("Exception at Sign Up : " + e);
            return BaseResponse.failure(e.getMessage());
        }
    }

    @PostMapping("/login")
    public BaseResponse<?> login(
            @RequestBody LoginRequest loginRequestBody
    ) {
        try {
            LoginResponse loginResponse = authService.login(loginRequestBody);
            return BaseResponse.success(loginResponse);
        } catch (AuthException e) {
            log.error("Exception at Login : " + e);
            return BaseResponse.failure(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public BaseResponse<?> logout(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
//        logoutService.logout(request, response);
        return null;
    }

}
