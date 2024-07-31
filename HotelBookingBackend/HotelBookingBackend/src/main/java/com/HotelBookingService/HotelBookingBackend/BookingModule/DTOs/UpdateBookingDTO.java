package com.HotelBookingService.HotelBookingBackend.BookingModule.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UpdateBookingDTO {

    private long bookingId;
    private List<Long> updatedRoomIds;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
//    private LocalDateTime bookingDate;
}
