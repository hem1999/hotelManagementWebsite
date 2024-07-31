package com.HotelBookingService.HotelBookingBackend.RoomsModule;

import com.HotelBookingService.HotelBookingBackend.RoomsModule.DTOs.AddRoomDTO;
import com.HotelBookingService.HotelBookingBackend.RoomsModule.DTOs.GetRoomDTO;
import com.HotelBookingService.HotelBookingBackend.RoomsModule.DTOs.UpdateRoomDTO;

import java.util.List;
import java.util.Optional;

public interface RoomServices {
    public boolean addRoom(AddRoomDTO roomEntity);
    public boolean deleteRoom(Long roomId);
    public boolean updateRoom(UpdateRoomDTO updateRoomDTO);
    public  List<GetRoomDTO> getAllRooms();
    public Optional<GetRoomDTO> GetRoomById(Long roomId);

}
