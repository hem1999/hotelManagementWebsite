package com.HotelBookingService.HotelBookingBackend.UserModule;

import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {

    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        return this.userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return this.userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public UserEntity findUserById(Long id) {
        Optional<UserEntity> user = this.userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public boolean addUser(UserEntity userEntity) {
        try {
            this.userRepository.save(userEntity);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateUser(UserEntity userEntity) {
            Optional<UserEntity> oldUserEntity = this.userRepository.findById(userEntity.getUserId());
            if(oldUserEntity.isPresent()){
                UserEntity user = oldUserEntity.get();
                user.setPassword(userEntity.getPassword());
                user.setFirstName(userEntity.getFirstName());
                user.setLastName(userEntity.getLastName());
                user.setPhone(userEntity.getPhone());
                this.userRepository.save(user);
                return true;
            }
            return false;

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
