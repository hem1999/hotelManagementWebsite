package com.HotelBookingService.HotelBookingBackend.BookingModule;

import com.HotelBookingService.HotelBookingBackend.RoomsModule.RoomEntity;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class GetBookingDTO {

    private Long bookingId;
    private LocalDateTime bookingDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Map<Long,String> roomIdsNamesMap;
    private Long customerId;
    private String customerName;

    public GetBookingDTO makeGetBookingDTOFromBookingEntity(BookingEntity bookingEntity) {
        GetBookingDTO getBookingDTO = new GetBookingDTO();
        getBookingDTO.setBookingId(bookingEntity.getBookingId());
        getBookingDTO.setBookingDate(bookingEntity.getBookingDate());
        getBookingDTO.setStartDate(bookingEntity.getStartDate());
        getBookingDTO.setEndDate(bookingEntity.getEndDate());
        getBookingDTO.setCustomerId(bookingEntity.getUser().getUserId());
        getBookingDTO.setCustomerName(bookingEntity.getUser().getFirstName()+" "+bookingEntity.getUser().getLastName());
        Map<Long,String> roomIdsNamesMap = new HashMap<>();
        for(RoomEntity r: bookingEntity.getRooms()) {
            roomIdsNamesMap.put(r.getRoomId(), r.getRoomName());
        }
        getBookingDTO.setRoomIdsNamesMap(roomIdsNamesMap);
        return getBookingDTO;

    }

}
