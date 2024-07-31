package com.HotelBookingService.HotelBookingBackend.UserModule;

import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    public UserServiceImpl userServiceImpl;

    UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Long id) {
        UserEntity ue = this.userServiceImpl.findUserById(id);
        if(ue == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ue);
    }
    // TODO: do it later
//    @GetMapping(path = "/allUsers")
//    public ResponseEntity<List<UserEntity>> getAllUsers() {
//        List<UserEntity> lue = this.userServiceImpl.
//    }

    @PostMapping(path = "/addUser")
    public ResponseEntity<AddUserDTO> addUser(@RequestBody AddUserDTO user) {
        if(this.userServiceImpl.addUser(user)){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(path="/updateUser")
    public ResponseEntity<updateUserDTO> updateUser(@RequestBody updateUserDTO user) {
        if(this.userServiceImpl.updateUser(user)){
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path="/deleteUser/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable Long id) {
        if(this.userServiceImpl.deleteUser(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/userBookings/{id}")
    public ResponseEntity<List<BookingEntity>> getUserBookings(@PathVariable Long id) {
        List<BookingEntity> bookings = this.userServiceImpl.getBookings(id);
        return ResponseEntity.ok(bookings);
    }

}
