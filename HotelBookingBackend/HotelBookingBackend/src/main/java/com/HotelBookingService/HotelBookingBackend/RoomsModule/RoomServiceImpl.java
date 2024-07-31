package com.HotelBookingService.HotelBookingBackend.RoomsModule;

import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;
import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingRepository;
import com.HotelBookingService.HotelBookingBackend.UserModule.UserEntity;
import com.HotelBookingService.HotelBookingBackend.UserModule.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomServices{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

//    public RoomServiceImpl(RoomRepository roomRepository) {
//        this.roomRepository = roomRepository;
//    }

    @Override
    public boolean addRoom(RoomEntityPostRequestDTO roomEntity) {
        try {
            if(roomEntity.getCreatorId() == null){
                throw new IllegalArgumentException("Creater id cannot be null");
            }

            RoomEntity r = new RoomEntity();
            r.setRoomName(roomEntity.getRoomName());
            r.setRoomDescription(roomEntity.getRoomDescription());
            r.setRoomType(roomEntity.getRoomType());
            r.setRoomCapacity(roomEntity.getRoomCapacity());
            Optional<UserEntity> creator = this.userRepository.findById(roomEntity.getCreatorId());
            if(creator.isEmpty()){
                throw new EntityNotFoundException("User not found");
            }
            r.setCreatedByUser(creator.get());
            if(roomEntity.getBookingId() != null){
                Optional<BookingEntity> booking = this.bookingRepository.findById(roomEntity.getBookingId());
                if(booking.isEmpty()){
                    throw new EntityNotFoundException("Booking not found");
                }
                r.setBooking(booking.get());
            }
            roomRepository.save(r);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteRoom(Long roomId) {
        try {
            roomRepository.deleteById(roomId);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateRoom(RoomEntity roomEntity) {
        Optional<RoomEntity> r = roomRepository.findById(roomEntity.getRoomId());
        if(r.isPresent()) {
            RoomEntity oldRoom = r.get();

            oldRoom.setRoomName(roomEntity.getRoomName());
            oldRoom.setRoomCapacity(roomEntity.getRoomCapacity());
            oldRoom.setRoomDescription(roomEntity.getRoomDescription());
            oldRoom.setRoomType(roomEntity.getRoomType());
            System.out.println(roomEntity.getBooking());
            if(roomEntity.getBooking() != null){
                oldRoom.setBooking(roomEntity.getBooking());
            }
            if(roomEntity.getRoomType() != null) {
                oldRoom.setRoomType(roomEntity.getRoomType());
            }
            roomRepository.save(oldRoom);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public List<RoomEntity> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<RoomEntity> GetRoomById(Long roomId) {
        return roomRepository.findById(roomId);
    }


}
