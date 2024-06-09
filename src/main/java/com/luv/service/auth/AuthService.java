package com.luv.service.auth;

import com.luv.config.security.JwtService;
import com.luv.dao.request.LoginRequest;
import com.luv.dao.request.SignUpRequest;
import com.luv.dao.response.LoginResponse;
import com.luv.dao.response.SignUpResponse;
import com.luv.model.User;
import com.luv.repository.UserRepository;
import com.luv.service.UserService;
import com.luv.util.enums.Role;
import com.luv.util.exception.AuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest loginRequest) throws AuthException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        if (userService.isUserPresent(loginRequest.getEmail())) {
            User user = userService.getUser(loginRequest.getEmail());
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                String accessToken = jwtService.generateToken(user);
                return LoginResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken("TODO")// TODO: Implement Refresh Token
                        .build();
            } else throw new BadCredentialsException("Incorrect Password!");
        } else throw new AuthException();
    }

    //TODO: Generate token during signup for direct login
    //TODO: Check SQL relation warning log
    public SignUpResponse signUp(SignUpRequest signUpRequest) throws AuthException {
        if (!userService.isUserPresent(signUpRequest.getEmail())) {
            User newUser = User.builder()
                    .role(Role.USER)// TODO: Default role set as USER during signup
                    .email(signUpRequest.getEmail())
                    .password(passwordEncoder.encode(signUpRequest.getRawPassword()))
                    .firstname(signUpRequest.getFirstname())
                    .lastname(signUpRequest.getLastname())
                    .build();

            User createdUser = userRepository.save(newUser);
            return SignUpResponse.builder()
                    .userId(createdUser.getUserId())
                    .build();
        } else {
            throw new AuthException("User with email: " + signUpRequest.getEmail() + " is already present!");
        }
    }
}
