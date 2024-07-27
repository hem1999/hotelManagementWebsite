package com.HotelBookingService.HotelBookingBackend.UserModule;

import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;
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
        try{
            UserEntity user = this.userRepository.findBy()
        }
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return null;
    }

    @Override
    public UserEntity findUserById(int id) {
        return null;
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
            Optional<UserEntity> oldUserEntity = this.userRepository.findById(userEntity.getUserid());
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
    public boolean deleteUser(UserEntity userEntity) {

        try{
            this.userRepository.delete(userEntity);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<BookingEntity> getBookings(Long userId) {
        try{
            UserEntity user = this.userRepository.findById(userId).get();
            return user.getBookings();

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
