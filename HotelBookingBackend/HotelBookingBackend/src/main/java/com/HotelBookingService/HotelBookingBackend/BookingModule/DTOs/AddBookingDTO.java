package com.HotelBookingService.HotelBookingBackend.BookingModule.DTOs;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
public class AddBookingDTO {

    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate bookingDate;
    private List<Long> roomIds;
}
