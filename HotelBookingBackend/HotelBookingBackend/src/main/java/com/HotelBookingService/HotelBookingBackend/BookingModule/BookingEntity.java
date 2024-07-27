package com.HotelBookingService.HotelBookingBackend.BookingModule;

import com.HotelBookingService.HotelBookingBackend.RoomsModule.RoomEntity;
import com.HotelBookingService.HotelBookingBackend.UserModule.UserEntity;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class BookingEntity {
    @Id
    @GeneratedValue
    @Column()
    private Long bookingId;

//    @ManyToOne
//    @JoinColumn(name = "userId")
//    public UserEntity user;

    @OneToMany(mappedBy = "booking")
    public List<RoomEntity> rooms;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }


    public List<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomEntity> rooms) {
        this.rooms = rooms;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }


}
