package com.HotelBookingService.HotelBookingBackend.RoomsModule;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomsController {
    private RoomServiceImpl roomServiceImpl;
    public RoomsController(RoomServiceImpl roomServiceImpl) {
        this.roomServiceImpl = roomServiceImpl;
    }
    @GetMapping()
    public ResponseEntity<List<RoomEntity>> getAllRooms(){
        List<RoomEntity> rooms = this.roomServiceImpl.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<RoomEntity> getRoomById(@PathVariable("id") Long id){
        Optional<RoomEntity> r = this.roomServiceImpl.GetRoomById(id);
        if(r.isPresent()){
            return ResponseEntity.ok(r.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<RoomEntity> addRoom(@RequestBody RoomEntity room){
        boolean res = this.roomServiceImpl.addRoom(room);
        if(res) {
            return ResponseEntity.ok(room);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<RoomEntity> updateRoom(@RequestBody RoomEntity room){
        boolean res = this.roomServiceImpl.updateRoom(room);
        if(res) {
            return ResponseEntity.ok(room);
        }
        return ResponseEntity.badRequest().build();
    }
}
