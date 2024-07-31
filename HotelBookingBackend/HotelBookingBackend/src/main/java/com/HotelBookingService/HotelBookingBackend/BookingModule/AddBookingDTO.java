package com.HotelBookingService.HotelBookingBackend.BookingModule;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
public class AddBookingDTO {

    private Long userId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime bookingDate;
    private List<Long> roomIds;
}
