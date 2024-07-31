package com.HotelBookingService.HotelBookingBackend.RoomsModule;



import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity,Long> {

    List<RoomEntity> bookedRoomsBetweenStartDateAndEndDate(LocalDate startDate, LocalDate endDate);
}
