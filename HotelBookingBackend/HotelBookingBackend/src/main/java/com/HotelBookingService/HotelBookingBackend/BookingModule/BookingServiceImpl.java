package com.HotelBookingService.HotelBookingBackend.BookingModule;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingServices{
    private BookingRepository bookingRepository;
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    @Override
    public boolean addBooking(BookingEntity bookingEntity) {
        try{
            bookingRepository.save(bookingEntity);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteBooking(Long booking_id) {
        try {
            this.bookingRepository.deleteById(booking_id);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateBooking(BookingEntity bookingEntity) {
        Optional<BookingEntity> oldBooking = bookingRepository.findById(bookingEntity.getBookingId());
        if(oldBooking.isPresent()){
            BookingEntity bookingEntity1 = oldBooking.get();
            bookingEntity1.setBookingId(bookingEntity.getBookingId());
            bookingEntity1.setRooms(bookingEntity.getRooms());
            bookingEntity1.setEndDate(bookingEntity.getEndDate());
            bookingEntity1.setStartDate(bookingEntity.getStartDate());
            bookingEntity1.setUser(bookingEntity.getUser());
            this.bookingRepository.save(bookingEntity1);
            return true;
        }
        return false;
    }

    @Override
    public List<BookingEntity> getAllBookings() {
        return this.bookingRepository.findAll();
    }

    @Override
    public BookingEntity getBookingById(Long booking_id) {
        Optional<BookingEntity> b = this.bookingRepository.findById(booking_id);
        if(b.isPresent()){
            return b.get();
        }
        return null;

    }
}
