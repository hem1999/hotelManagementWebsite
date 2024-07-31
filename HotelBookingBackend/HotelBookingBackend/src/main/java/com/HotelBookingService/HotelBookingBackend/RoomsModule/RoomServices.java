package com.HotelBookingService.HotelBookingBackend.RoomsModule;

import java.util.List;
import java.util.Optional;

public interface RoomServices {
    public boolean addRoom(RoomEntityPostRequestDTO roomEntity);
    public boolean deleteRoom(Long roomId);
    public boolean updateRoom(RoomEntity roomEntity);

    public default List<RoomEntity> getAllRooms() {
        return null;
    }
    public Optional<RoomEntity> GetRoomById(Long roomId);

}
