package com.scaler.bookmyshow.DTOs;

import com.scaler.bookmyshow.Models.Enums.SignupResponseStatus;
import com.scaler.bookmyshow.Models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDTO {
    User user;
    SignupResponseStatus responseStatus;
}
