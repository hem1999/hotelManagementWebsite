package com.HotelBookingService.HotelBookingBackend.UserModule;


import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;
import com.HotelBookingService.HotelBookingBackend.UserModule.DTOs.AddUserDTO;
import com.HotelBookingService.HotelBookingBackend.UserModule.DTOs.GetUserDTO;
import com.HotelBookingService.HotelBookingBackend.UserModule.DTOs.updateUserDTO;

import java.util.List;

public interface UserServices {
     GetUserDTO findUserByEmail(String email);
     GetUserDTO findUserByUsername(String username);
     GetUserDTO findUserById(Long id);
     boolean addUser(AddUserDTO addUserDTO);
     boolean updateUser(updateUserDTO userEntity);
     boolean deleteUser(Long userId);
     List<BookingEntity> getBookings(Long userId);
}
