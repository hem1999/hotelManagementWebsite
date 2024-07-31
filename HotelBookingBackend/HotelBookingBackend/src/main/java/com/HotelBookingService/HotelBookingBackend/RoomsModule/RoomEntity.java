package com.HotelBookingService.HotelBookingBackend.RoomsModule;

import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;
import com.HotelBookingService.HotelBookingBackend.UserModule.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class RoomEntity {
    @Id
    @GeneratedValue
    @Column()
    private Long roomId;
    private String roomName;
    private String roomType;
    private int roomCapacity;
    private String roomDescription;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity booking;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private UserEntity createdByUser;
}
