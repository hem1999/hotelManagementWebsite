package com.HotelBookingService.HotelBookingBackend.RoomsModule;

import com.HotelBookingService.HotelBookingBackend.RoomsModule.DTOs.AddRoomDTO;
import com.HotelBookingService.HotelBookingBackend.RoomsModule.DTOs.GetRoomDTO;
import com.HotelBookingService.HotelBookingBackend.RoomsModule.DTOs.UpdateRoomDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RoomServices {
     boolean addRoom(AddRoomDTO roomEntity);
     boolean deleteRoom(Long roomId);
     boolean updateRoom(UpdateRoomDTO updateRoomDTO);
      List<GetRoomDTO> getAllRooms();
     Optional<GetRoomDTO> GetRoomById(Long roomId);
     List<GetRoomDTO> getAllRoomsAvailableBetweenDates(LocalDate startDate, LocalDate endDate);

}
