package com.HotelBookingService.HotelBookingBackend.RoomsModule;

import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;
import com.HotelBookingService.HotelBookingBackend.FeedbackModule.FeedbackEntity;

import java.util.List;
import java.util.Optional;

public interface RoomServices {
    public boolean addRoom(RoomEntity roomEntity);
    public boolean deleteRoom(Long roomId);
    public boolean updateRoom(RoomEntity roomEntity);

    public default List<RoomEntity> getAllRooms() {
        return null;
    }
    public Optional<RoomEntity> GetRoomById(Long roomId);
    public List<FeedbackEntity> feedbacksByRoomId(Long roomId);
}
