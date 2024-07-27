package com.HotelBookingService.HotelBookingBackend.RoomsModule;

import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;
import com.HotelBookingService.HotelBookingBackend.FeedbackModule.FeedbackEntity;
import jakarta.persistence.*;

import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "bookingId")
    private BookingEntity booking;

    @OneToMany
    private List<FeedbackEntity> feedbacks;

    public BookingEntity getBookingEntity() {
        return booking;
    }

    public BookingEntity getBooking() {
        return booking;
    }

    public void setBooking(BookingEntity booking) {
        this.booking = booking;
    }

    public List<FeedbackEntity> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<FeedbackEntity> feedbacks) {
        this.feedbacks = feedbacks;
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
