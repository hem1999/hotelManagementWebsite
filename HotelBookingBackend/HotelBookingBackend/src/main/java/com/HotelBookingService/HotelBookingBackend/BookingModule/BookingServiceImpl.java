package com.HotelBookingService.HotelBookingBackend.BookingModule;

import com.HotelBookingService.HotelBookingBackend.BookingModule.DTOs.AddBookingDTO;
import com.HotelBookingService.HotelBookingBackend.BookingModule.DTOs.GetBookingDTO;
import com.HotelBookingService.HotelBookingBackend.BookingModule.DTOs.UpdateBookingDTO;
import com.HotelBookingService.HotelBookingBackend.RoomsModule.RoomEntity;
import com.HotelBookingService.HotelBookingBackend.RoomsModule.RoomRepository;
import com.HotelBookingService.HotelBookingBackend.UserModule.UserEntity;
import com.HotelBookingService.HotelBookingBackend.UserModule.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingServices{
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    public BookingServiceImpl(BookingRepository bookingRepository, UserRepository userRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }
    @Override
    public boolean addBooking(AddBookingDTO addBookingDTO) {
        try{
            BookingEntity b = new BookingEntity();
            if(addBookingDTO.getStartDate() != null) {
                b.setStartDate(addBookingDTO.getStartDate());
            }
            if(addBookingDTO.getEndDate() != null) {
                b.setEndDate(addBookingDTO.getEndDate());
            }
            b.setBookingDate(LocalDateTime.now());
            //check for userId
            Optional<UserEntity> user = this.userRepository.findById(addBookingDTO.getUserId());
            if(user.isPresent()){
                UserEntity userEntity = user.get();
                b.setUser(userEntity);
            }else{
                throw new EntityNotFoundException("User Not Found");
            }
            // Process the rooms
            List<RoomEntity> rooms = new ArrayList<>();
            for(Long roomId: addBookingDTO.getRoomIds()){
                Optional<RoomEntity> room = this.roomRepository.findById(roomId);
                if(room.isPresent()){
                    rooms.add(room.get());
                }else{
                    throw new EntityNotFoundException("Room Not Found");
                }
            }
            b.setRooms(rooms);
            this.bookingRepository.save(b);
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
    public boolean updateBooking(UpdateBookingDTO updateBookingDTO) {
        Optional<BookingEntity> oldBooking = bookingRepository.findById(updateBookingDTO.getBookingId());
        if(oldBooking.isPresent()) {

            BookingEntity b = oldBooking.get();
            //dealing with time updates.
            // TODO: First check for availabilities!
            if(updateBookingDTO.getStartDate() != null) {
                b.setStartDate(updateBookingDTO.getStartDate());
            }// TIP: Since you are sending UpdateBookingDTO as return value in response,
            // If any attribute is null, it will show as null in response,
            // So trust the updates with another GET request, not this
            if(updateBookingDTO.getEndDate() != null) {
                b.setEndDate(updateBookingDTO.getEndDate());
            }
            /*if (updateBookingDTO.getBookingDate() != null){
                b.setBookingDate(updateBookingDTO.getBookingDate());
            }*/
            //dealing with room updates

            for (RoomEntity room : b.getRooms()) {
                room.setBooking(null);
            }
            List<RoomEntity> rooms = new ArrayList<>();
            for (Long roomId : updateBookingDTO.getUpdatedRoomIds()) {
                Optional<RoomEntity> room = this.roomRepository.findById(roomId);
                if (room.isPresent()) {
                    RoomEntity r = room.get();
                    r.setBooking(b);
                    this.roomRepository.save(r);
                    rooms.add(r);
                } else {
                    throw new EntityNotFoundException("Room Not Found with id: " + roomId);
                }
            }
            b.setRooms(rooms);
            this.bookingRepository.save(b);
            return true;
        }
        throw new EntityNotFoundException("Booking Not Found");
    }

    @Override
    public List<GetBookingDTO> getAllBookings() {
        List<GetBookingDTO> bookings = new ArrayList<>();
        for(BookingEntity b: this.bookingRepository.findAll()){
            bookings.add(new GetBookingDTO().makeGetBookingDTOFromBookingEntity(b));
        }
        return bookings;
    }

    @Override
    public GetBookingDTO getBookingById(Long booking_id) {
        Optional<BookingEntity> b = this.bookingRepository.findById(booking_id);
        if(b.isEmpty()){
            throw new EntityNotFoundException("Booking Not Found with id: " + booking_id);
        }
        return new GetBookingDTO().makeGetBookingDTOFromBookingEntity(b.get());
    }
}
