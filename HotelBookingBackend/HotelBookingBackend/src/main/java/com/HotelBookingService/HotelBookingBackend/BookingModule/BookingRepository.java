package com.HotelBookingService.HotelBookingBackend.BookingModule;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<BookingEntity,Long> {
}
