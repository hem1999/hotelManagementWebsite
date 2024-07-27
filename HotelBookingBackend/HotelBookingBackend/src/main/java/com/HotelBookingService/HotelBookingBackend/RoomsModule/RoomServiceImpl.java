package com.HotelBookingService.HotelBookingBackend.RoomsModule;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomServices{

    private final RoomRepository roomRepository;
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public boolean addRoom(RoomEntity roomEntity) {
        try {
            roomRepository.save(roomEntity);
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
