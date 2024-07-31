package com.HotelBookingService.HotelBookingBackend.RoomsModule;

import lombok.Getter;
import lombok.Setter;

/*
* This is created to make sure and get only user_id and deal with it on server,
* Instead of taking whole user object in the request body.*/
@Getter
@Setter
public class AddRoomDTO {
    private String roomName;
    private String roomType;
    private String roomDescription;
    private int roomCapacity;
    private Long creatorId;

}
