package com.HotelBookingService.HotelBookingBackend.UserModule;

import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;
import com.HotelBookingService.HotelBookingBackend.UserModule.DTOs.AddUserDTO;
import com.HotelBookingService.HotelBookingBackend.UserModule.DTOs.GetUserDTO;
import com.HotelBookingService.HotelBookingBackend.UserModule.DTOs.updateUserDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {


    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public GetUserDTO findUserByEmail(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if(user.isEmpty()){
            throw new EntityNotFoundException("User not found with email" + email);
        }
        return new GetUserDTO().makeGetUserDTOFromEntity(user.get());
    }

    @Override
    public GetUserDTO findUserByUsername(String username) {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if(user.isEmpty()){
            throw new EntityNotFoundException("User not found with username" + username);
        }
        return new GetUserDTO().makeGetUserDTOFromEntity(user.get());
    }

    @Override
    public GetUserDTO findUserById(Long id) {
        Optional<UserEntity> user = this.userRepository.findById(id);
        if(user.isEmpty()){
            throw new EntityNotFoundException("User not found with id " + id);
        }
        return new GetUserDTO().makeGetUserDTOFromEntity(user.get());
    }

    @Override
    public boolean addUser(AddUserDTO addUserDTO) {
        try {
            UserEntity user = new UserEntity();
            user.setEmail(addUserDTO.getEmail());
            user.setPassword(addUserDTO.getPassword());
            user.setFirstName(addUserDTO.getFirstName());
            user.setLastName(addUserDTO.getLastName());
            user.setPhone(addUserDTO.getPhone());
            user.setUserType(addUserDTO.getUserType());
            user.setUsername(addUserDTO.getUsername());
            this.userRepository.save(user);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateUser(updateUserDTO userDTO) {
            Optional<UserEntity> oldUserEntity = this.userRepository.findById(userDTO.getUserId());
            if(oldUserEntity.isPresent()){
                UserEntity user = oldUserEntity.get();
                user.setFirstName(userDTO.getFirstName());
                user.setLastName(userDTO.getLastName());
                user.setPhone(userDTO.getPhone());
                user.setUserType(userDTO.getUserType());
                this.userRepository.save(user);
                return true;
            }else{
                throw new EntityNotFoundException("User not found");
            }

    }

    @Override
    public boolean deleteUser(Long userId) {
        Optional<UserEntity> user = this.userRepository.findById(userId);
        if(user.isPresent()){
            this.userRepository.delete(user.get());
            return true;
        }
        return false;
    }

    @Override
    public List<BookingEntity> getBookings(Long userId) {
        Optional<UserEntity> ue  = this.userRepository.findById(userId);
        return ue.map(UserEntity::getBookings).orElse(null);
    }
}
