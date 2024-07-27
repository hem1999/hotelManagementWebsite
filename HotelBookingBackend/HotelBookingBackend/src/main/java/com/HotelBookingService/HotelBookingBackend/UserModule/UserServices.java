package com.HotelBookingService.HotelBookingBackend.UserModule;


import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;
import org.apache.catalina.User;

import java.util.List;

public interface UserServices {

    public UserEntity findUserByEmail(String email);
    public UserEntity findUserByUsername(String username);
    public UserEntity findUserById(Long id);
    public boolean addUser(UserEntity userEntity);
    public boolean updateUser(UserEntity userEntity);
    public boolean deleteUser(Long userId);
    public List<BookingEntity> getBookings(Long userId);
}
