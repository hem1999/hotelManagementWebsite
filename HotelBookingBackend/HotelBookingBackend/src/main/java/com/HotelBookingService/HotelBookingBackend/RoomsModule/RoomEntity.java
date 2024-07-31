package com.HotelBookingService.HotelBookingBackend.RoomsModule;

import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;
import com.HotelBookingService.HotelBookingBackend.UserModule.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NamedQuery(
        name = "RoomEntity.bookedRoomsBetweenStartDateAndEndDate",
        query= "select r from RoomEntity r where r.roomId not in (select br.roomId from BookingEntity b inner join b.rooms br where b.startDate<=:endDate and b.endDate>=:startDate)"
)
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
    @ManyToMany(mappedBy = "rooms")
    private List<BookingEntity> bookings;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private UserEntity createdByUser;
}
