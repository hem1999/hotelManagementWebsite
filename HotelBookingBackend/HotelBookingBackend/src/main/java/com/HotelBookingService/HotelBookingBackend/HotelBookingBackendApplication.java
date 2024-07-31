package com.HotelBookingService.HotelBookingBackend;

import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingEntity;
import com.HotelBookingService.HotelBookingBackend.BookingModule.BookingRepository;
import com.HotelBookingService.HotelBookingBackend.RoomsModule.RoomEntity;
import com.HotelBookingService.HotelBookingBackend.RoomsModule.RoomRepository;
import com.HotelBookingService.HotelBookingBackend.UserModule.UserEntity;
import com.HotelBookingService.HotelBookingBackend.UserModule.UserRepository;
import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HotelBookingBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(HotelBookingBackendApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner commandLineRunner(
			UserRepository userRepository,
			RoomRepository roomRepository,
			BookingRepository bookingRepository
	) {
		return args -> {
			System.out.println("Storing Data ...");
			//creating an admin entity
			var user = new UserEntity();
			user.setUsername("admin");
			user.setPassword("admin");
			user.setFirstName("f1");
			user.setLastName("l1");
			user.setEmail("admin@admin.com");
			user.setPhone("9998887771");
			user.setUserType("ADMIN");
			userRepository.save(user);

			var user3 = new UserEntity();
			user3.setUsername("admin2");
			user3.setPassword("admin2");
			user3.setFirstName("f3");
			user3.setLastName("l3");
			user3.setEmail("admin2@admin.com");
			user3.setPhone("9998887773");
			user3.setUserType("ADMIN");
			userRepository.save(user3);

			// customer entities
			var user2 = new UserEntity();
			user2.setUsername("customer1");
			user2.setPassword("customer1");
			user2.setFirstName("f2");
			user2.setLastName("l2");
			user2.setEmail("f2@l2.com");
			user2.setPhone("9998887772");
			user2.setUserType("CUSTOMER");
			userRepository.save(user2);

			var user4 = new UserEntity();
			user4.setUsername("customer2");
			user4.setPassword("customer2");
			user4.setFirstName("f4");
			user4.setLastName("l4");
			user4.setEmail("f4@l4.com");
			user4.setPhone("9998887774");
			user4.setUserType("CUSTOMER");
			userRepository.save(user4);

			//creating an room entity
			var room = new RoomEntity();
			room.setRoomName("room1");
			room.setCreatedByUser(user);
			room.setRoomCapacity(4);
			room.setRoomDescription("Louzy and luxury suite");
			room.setRoomType("SUITE");
			roomRepository.save(room);

			var room2 = new RoomEntity();
			room2.setRoomName("room2");
			room2.setCreatedByUser(user3);
			room2.setRoomCapacity(2);
			room2.setRoomType("DELUXE");
			room2.setRoomDescription("Clean room with a bed and wifi");
			roomRepository.save(room2);

			var room3 = new RoomEntity();
			room3.setRoomName("room3");
			room3.setCreatedByUser(user);
			room3.setRoomCapacity(3);
			room3.setRoomType("PENTHOUSE");
			room3.setRoomDescription("Room on 21st floor with an excellent view");
			roomRepository.save(room3);

			var room4 = new RoomEntity();
			room4.setRoomName("room4");
			room4.setCreatedByUser(user3);
			room4.setRoomCapacity(4);
			room4.setRoomType("SUITE");
			room4.setRoomDescription("Nice suite room!");
			roomRepository.save(room4);

			//creating an bookingEntity
			var booking = new BookingEntity();
			var myrooms = new ArrayList<RoomEntity>();
			myrooms.add(room);
			booking.setRooms(myrooms);
			booking.setStartDate(LocalDateTime.now());
			booking.setEndDate(LocalDateTime.now().plusDays(2));
			booking.setUser(user);
			bookingRepository.save(booking);
			room.setBooking(booking);
			roomRepository.save(room);

			//second booking to room2 and room3 by user4
			var booking2 = new BookingEntity();
			List<RoomEntity> myrooms2 = new ArrayList<RoomEntity>();
			myrooms2.add(room2);
			myrooms2.add(room4);
			booking2.setRooms(myrooms2);
			booking2.setStartDate(LocalDateTime.now());
			booking2.setEndDate(LocalDateTime.now().plusDays(2));
			booking2.setUser(user3);
			bookingRepository.save(booking2);


			System.out.println("setting up room2 booking 2");
			room2.setBooking(booking2);
			roomRepository.save(room2);

			System.out.println("setting up room4 booking 2");
			room4.setBooking(booking2);
			roomRepository.save(room4);

			System.out.println("setup complete, fetching data ...");

			System.out.println("rooms booked in booking 2");
			for(RoomEntity r: booking2.getRooms()) {
				System.out.println(r.getRoomId());
			}


		};
	}*/

}
