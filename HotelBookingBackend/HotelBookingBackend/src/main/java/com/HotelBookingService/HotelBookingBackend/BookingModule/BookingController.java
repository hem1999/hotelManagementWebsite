package com.HotelBookingService.HotelBookingBackend.BookingModule;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingServiceImpl bookingService;

    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<GetBookingDTO>> getBookings() {
        try {
            List<GetBookingDTO> b = this.bookingService.getAllBookings();
            return ResponseEntity.ok(b);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetBookingDTO> getBookingById(@PathVariable Long id) {
        GetBookingDTO b = this.bookingService.getBookingById(id);
        if (b != null) {
            return ResponseEntity.ok(b);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addBooking")
    public ResponseEntity<AddBookingDTO> addBooking(@RequestBody AddBookingDTO addBookingDTO) {
        if (this.bookingService.addBooking(addBookingDTO)) {
            return new ResponseEntity<>(addBookingDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateBooking")
    public ResponseEntity<UpdateBookingDTO> updateBooking(@RequestBody UpdateBookingDTO booking) {
        boolean isValid = this.bookingService.updateBooking(booking);
        if (isValid) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        boolean isValid = this.bookingService.deleteBooking(id);
        if (isValid) {
            return ResponseEntity.ok("Deleted!");
        }
        return ResponseEntity.notFound().build();
    }
}
