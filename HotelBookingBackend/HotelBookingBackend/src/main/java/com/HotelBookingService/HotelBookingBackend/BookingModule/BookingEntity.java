package com.HotelBookingService.HotelBookingBackend.BookingModule;

import com.HotelBookingService.HotelBookingBackend.RoomsModule.RoomEntity;
import com.HotelBookingService.HotelBookingBackend.UserModule.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class BookingEntity {
    @Id
    @GeneratedValue
    @Column()
    private Long bookingId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fk_buser_id")
    public UserEntity user;

    @JsonIgnore
    @JoinTable(
        name = "bookings_rooms",
        joinColumns={
                @JoinColumn(name = "booking_id")
        },
            inverseJoinColumns = {
                @JoinColumn(name = "room_id")
            }

    )
    @ManyToMany
    public List<RoomEntity> rooms;

    public LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime bookingDate;

}
