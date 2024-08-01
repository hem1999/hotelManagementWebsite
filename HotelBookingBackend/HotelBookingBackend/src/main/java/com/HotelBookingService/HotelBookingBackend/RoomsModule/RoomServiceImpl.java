package com.HotelBookingService.HotelBookingBackend.RoomsModule;



import com.HotelBookingService.HotelBookingBackend.RoomsModule.DTOs.AddRoomDTO;
import com.HotelBookingService.HotelBookingBackend.RoomsModule.DTOs.GetRoomDTO;
import com.HotelBookingService.HotelBookingBackend.RoomsModule.DTOs.UpdateRoomDTO;
import com.HotelBookingService.HotelBookingBackend.UserModule.UserEntity;
import com.HotelBookingService.HotelBookingBackend.UserModule.UserRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomServices{


    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    public RoomServiceImpl(RoomRepository roomRepository, UserRepository userRepository) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;

    }



    @Override
    public boolean addRoom(AddRoomDTO roomEntity) {
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
            roomRepository.save(r);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteRoom(Long roomId) {
        Optional<RoomEntity> roomEntity = this.roomRepository.findById(roomId);
        if(roomEntity.isEmpty()){
            throw new EntityNotFoundException("Room not found with id: "+roomId);
        }
        roomRepository.delete(roomEntity.get());
        return true;
    }

    @Override
    public boolean updateRoom(UpdateRoomDTO updateRoomDTO) {
        Optional<RoomEntity> r = this.roomRepository.findById(updateRoomDTO.getRoomId());
        if(r.isEmpty()){
            throw new EntityNotFoundException("Room not found");
        }
        RoomEntity roomEntity = r.get();
        roomEntity.setRoomName(updateRoomDTO.getRoomName());
        roomEntity.setRoomDescription(updateRoomDTO.getRoomDescription());
        roomEntity.setRoomType(updateRoomDTO.getRoomType());
        roomEntity.setRoomCapacity(updateRoomDTO.getRoomCapacity());
        roomRepository.save(roomEntity);
        return true;

    }

    @Override
    public List<GetRoomDTO> getAllRooms() {
        List<GetRoomDTO> rooms = new ArrayList<>();
        for(RoomEntity r: this.roomRepository.findAll()){

            rooms.add(new GetRoomDTO().makeGetRoomDTOFromRoomEntity(r));
        }
        return rooms;
    }

    @Override
    public Optional<GetRoomDTO> GetRoomById(Long roomId) {
        Optional<RoomEntity> roomEntity = this.roomRepository.findById(roomId);
        if(roomEntity.isEmpty()){
            throw new EntityNotFoundException("Room not found with id: "+roomId);
        }
        RoomEntity r = roomEntity.get();
        return Optional.of(new GetRoomDTO().makeGetRoomDTOFromRoomEntity(r));
    }

    @Override
    public List<GetRoomDTO> getAllRoomsAvailableBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<RoomEntity> rooms = this.roomRepository.bookedRoomsBetweenStartDateAndEndDate(startDate, endDate);
        List<GetRoomDTO> roomDTOs = new ArrayList<>();
        for(RoomEntity r: rooms){
            roomDTOs.add(new GetRoomDTO().makeGetRoomDTOFromRoomEntity(r));
        }
        return roomDTOs;
    }

}
