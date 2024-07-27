package com.HotelBookingService.HotelBookingBackend.BookingModule;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private BookingServiceImpl bookingService;

    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<BookingEntity>> getBookings() {
        try {
            List<BookingEntity> b = this.bookingService.getAllBookings();
            return ResponseEntity.ok(b);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingEntity> getBookingById(@PathVariable Long id) {
        BookingEntity b = this.bookingService.getBookingById(id);
        if (b != null) {
            return ResponseEntity.ok(b);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addBooking")
    public ResponseEntity<BookingEntity> addBooking(@RequestBody BookingEntity booking) {
        boolean isValid = this.bookingService.addBooking(booking);
        if (isValid) {
            return ResponseEntity.ok(booking);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/updateBooking")
    public ResponseEntity<BookingEntity> updateBooking(@RequestBody BookingEntity booking) {
        boolean isValid = this.bookingService.updateBooking(booking);
        if (isValid) {
            return ResponseEntity.ok(booking);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookingEntity> deleteBooking(@PathVariable Long id) {
        boolean isValid = this.bookingService.deleteBooking(id);
        if (isValid) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
