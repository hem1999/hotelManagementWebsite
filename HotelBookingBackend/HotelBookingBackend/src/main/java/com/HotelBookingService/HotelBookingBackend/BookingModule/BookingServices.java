package com.HotelBookingService.HotelBookingBackend.BookingModule;

import java.util.List;

public interface BookingServices {

    public boolean addBooking(BookingEntity bookingEntity);
    public boolean deleteBooking(Long booking_id);
    public boolean updateBooking(BookingEntity bookingEntity);
    public List<BookingEntity> getAllBookings();
    public BookingEntity getBookingById(Long booking_id);
}
