package com.HotelBookingService.HotelBookingBackend.RoomsModule;

import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;
import jakarta.persistence.*;

@Entity
public class RoomEntity {
    @Id
    @GeneratedValue
    private Long roomId;
    private String roomName;
    private String roomType;
    private int roomCapacity;
    private String roomDescription;
    @ManyToOne
    @JoinColumn()
    private BookingEntity booking;

    public BookingEntity getBookingEntity() {
        return booking;
    }

    public void setBookingEntity(BookingEntity bookingEntity) {
        this.booking = bookingEntity;
    }



    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }




}
