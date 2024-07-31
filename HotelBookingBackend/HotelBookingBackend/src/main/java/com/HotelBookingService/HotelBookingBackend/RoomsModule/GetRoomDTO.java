package com.HotelBookingService.HotelBookingBackend.RoomsModule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetRoomDTO {

    private long roomId;
    private String roomName;
    private String roomDescription;
    private String roomType;
    private int roomCapacity;
    private Long bookingId;
    private Long CreatorId;
    private String CreatorName;

    public GetRoomDTO makeGetRoomDTOFromRoomEntity(RoomEntity r ) {
        GetRoomDTO getRoomDTO = new GetRoomDTO();
        getRoomDTO.setRoomId(r.getRoomId());
        getRoomDTO.setRoomName(r.getRoomName());
        getRoomDTO.setRoomDescription(r.getRoomDescription());
        getRoomDTO.setRoomType(r.getRoomType());
        getRoomDTO.setRoomCapacity(r.getRoomCapacity());
        if(r.getBooking() != null) {
            getRoomDTO.setBookingId(r.getBooking().getBookingId());
        }
        getRoomDTO.setCreatorId(r.getCreatedByUser().getUserId());
        getRoomDTO.setCreatorName(r.getCreatedByUser().getFirstName() + " " + r.getCreatedByUser().getLastName());
        return getRoomDTO;
    }
}
