package com.example.GraduationThesis.Service.API.InterfaceService.AdminAndUser.Authentication;

import com.example.GraduationThesis.Model.PayLoad.User.Authentication.Login.LoginRequest;
import com.example.GraduationThesis.Model.PayLoad.User.Authentication.Login.LoginResponse;
import com.example.GraduationThesis.Model.PayLoad.User.Authentication.SignUp.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface AuthenticationServiceAPI {

    ResponseEntity<String> signUp(SignupRequest signupRequest);

    LoginResponse login(@Valid @RequestBody LoginRequest loginRequest);
}
