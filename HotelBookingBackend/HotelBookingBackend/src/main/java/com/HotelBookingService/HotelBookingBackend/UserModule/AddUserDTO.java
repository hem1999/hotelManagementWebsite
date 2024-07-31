package com.HotelBookingService.HotelBookingBackend.UserModule;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddUserDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String userType;

    /* There will be no bookingIds or roomIds
        Since initial user doesn't have anything,
        those updates should only happen when you
        create a new room or new booking!

        In the update User also, you shouldn't touch the
        bookings and rooms, change those in the bookings or rooms respectively.
     */
}
