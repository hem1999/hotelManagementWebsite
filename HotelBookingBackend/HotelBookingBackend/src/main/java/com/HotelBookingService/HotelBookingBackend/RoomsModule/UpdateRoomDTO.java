package com.HotelBookingService.HotelBookingBackend.RoomsModule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRoomDTO {
    private long roomId;
    private String roomName;
    private String roomDescription;
    private int roomCapacity;
    private String roomType;
}
