package com.HotelBookingService.HotelBookingBackend.RoomsModule;

import com.HotelBookingService.HotelBookingBackend.RoomsModule.DTOs.AddRoomDTO;
import com.HotelBookingService.HotelBookingBackend.RoomsModule.DTOs.GetRoomDTO;
import com.HotelBookingService.HotelBookingBackend.RoomsModule.DTOs.UpdateRoomDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomsController {
    private final RoomServiceImpl roomServiceImpl;
    public RoomsController(RoomServiceImpl roomServiceImpl) {
        this.roomServiceImpl = roomServiceImpl;
    }
    @GetMapping()
    public ResponseEntity<List<GetRoomDTO>> getAllRooms(){
        List<GetRoomDTO> rooms = this.roomServiceImpl.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<GetRoomDTO>> getAllRoomsByFilter(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        List<GetRoomDTO> availableRooms = this.roomServiceImpl.getAllRoomsAvailableBetweenDates(startDate, endDate);
        return new ResponseEntity<>(availableRooms, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<GetRoomDTO> getRoomById(@PathVariable("id") Long id){
        Optional<GetRoomDTO> r = this.roomServiceImpl.GetRoomById(id);
        return r.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<AddRoomDTO> addRoom(@RequestBody AddRoomDTO room){
        boolean res = this.roomServiceImpl.addRoom(room);
        if(res) {
            return new ResponseEntity<>(room, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateRoomDTO> updateRoom(@RequestBody UpdateRoomDTO room){
        boolean res = this.roomServiceImpl.updateRoom(room);
        if(res) {
            return ResponseEntity.ok(room);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable("id") Long id){
        boolean res = this.roomServiceImpl.deleteRoom(id);
        if(res) {
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
