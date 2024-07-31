package com.HotelBookingService.HotelBookingBackend.UserModule;


import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;

import java.util.List;

public interface UserServices {
    public UserEntity findUserByEmail(String email);
    public UserEntity findUserByUsername(String username);
    public UserEntity findUserById(Long id);
    public boolean addUser(AddUserDTO addUserDTO);
    public boolean updateUser(updateUserDTO userEntity);
    public boolean deleteUser(Long userId);
    public List<BookingEntity> getBookings(Long userId);
}
