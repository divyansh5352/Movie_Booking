package com.scaler.bookmyshow.Controllers;

import com.scaler.bookmyshow.DTOs.SignUpRequestDTO;
import com.scaler.bookmyshow.DTOs.SignUpResponseDTO;
import com.scaler.bookmyshow.Exceptions.UserNotFoundException;
import com.scaler.bookmyshow.Models.Enums.SignupResponseStatus;
import com.scaler.bookmyshow.Models.User;
import com.scaler.bookmyshow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDTO signUp(SignUpRequestDTO requestDTO){
        SignUpResponseDTO responseDto = new SignUpResponseDTO();

        try {
            User user = userService.signup(requestDTO.getEmail(),requestDTO.getPassword());
            responseDto.setUser(user);
            responseDto.setResponseStatus(SignupResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(SignupResponseStatus.FAILURE);
        }
        return responseDto;
    }
    public User login ( String email , String password) throws UserNotFoundException {
        return userService.login(email,password);
    }
}
