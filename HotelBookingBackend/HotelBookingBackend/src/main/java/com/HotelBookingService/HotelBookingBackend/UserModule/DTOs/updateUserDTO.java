package com.HotelBookingService.HotelBookingBackend.UserModule.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class updateUserDTO {

    private long userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String phone;
    private String userType;
    // TODO:  to change the password, email you should have more secure way!
}
