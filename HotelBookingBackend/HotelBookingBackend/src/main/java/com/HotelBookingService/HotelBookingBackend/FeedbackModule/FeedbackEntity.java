package com.HotelBookingService.HotelBookingBackend.FeedbackModule;

import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;
import com.HotelBookingService.HotelBookingBackend.RoomsModule.RoomEntity;
import com.HotelBookingService.HotelBookingBackend.UserModule.UserEntity;
import jakarta.persistence.*;

@Entity
public class FeedbackEntity {
    @Id
    @GeneratedValue
    private FeedbackId feedbackId;

    @ManyToOne
    @JoinColumn(name="userId")
    private UserEntity user;

//    @ManyToOne
//    @JoinColumn(name = "roomId")
//    private RoomEntity room;
}
