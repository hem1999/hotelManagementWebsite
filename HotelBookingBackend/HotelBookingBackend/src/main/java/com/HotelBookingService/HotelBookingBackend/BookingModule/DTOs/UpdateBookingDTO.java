package com.HotelBookingService.HotelBookingBackend.BookingModule.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UpdateBookingDTO {

    private long bookingId;
    private List<Long> updatedRoomIds;
    private LocalDate startDate;
    private LocalDate endDate;

}
