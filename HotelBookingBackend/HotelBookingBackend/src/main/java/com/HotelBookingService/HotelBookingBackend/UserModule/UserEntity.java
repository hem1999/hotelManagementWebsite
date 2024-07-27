package com.HotelBookingService.HotelBookingBackend.UserModule;

import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;
import com.HotelBookingService.HotelBookingBackend.FeedbackModule.FeedbackEntity;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class UserEntity {

    @Column()
    @Id
    @GeneratedValue
    private long userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String userType;
    @OneToMany(mappedBy = "user")
    private List<BookingEntity> bookings;

    public List<FeedbackEntity> getFeedbackEntities() {
        return feedbackEntities;
    }

    public void setFeedbackEntities(List<FeedbackEntity> feedbackEntities) {
        this.feedbackEntities = feedbackEntities;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @OneToMany(mappedBy = "user")
    private List<FeedbackEntity> feedbackEntities;

//    public long getuserId() {
//        return userId;
//    }
//
//    public void setuserId(long userid) {
//        userId = userid;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<BookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingEntity> bookings) {
        this.bookings = bookings;
    }


}
