import {Component, inject, OnInit, signal, Signal, WritableSignal} from '@angular/core';
import { Room } from './room.model';
import { FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';


type availabilityStatus = 'NOT_CHECKED' | 'AVAILABLE' | 'NOT_AVAILABLE' | 'CHECKED';

@Component({
  selector: 'app-rooms',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './rooms.component.html',
  styleUrl: './rooms.component.css'
})
export class RoomsComponent implements OnInit{
  rooms: WritableSignal<Room[]> = signal<Room[]>([]);

  //injecting router to programatically navigate
  router = inject(Router);

  // Form control for startDate and endDate inputs to check for availability
  startDate = new FormControl(null,Validators.required);
  endDate = new FormControl(null,Validators.required);
  chkAvailabilityError:String = '';
  isAvailable:availabilityStatus  = 'NOT_CHECKED';
  // Form control for startDate and endDate inputs to fetch available rooms
  filterStartDate = new FormControl(null, Validators.required);
  filterEndDate = new FormControl(null, Validators.required);

  ngOnInit(){
    this.getRooms();
  }

  getRooms(){
    let allRooms: Room[]; 
    allRooms = [];
    for(let i=0; i<15;i++){
      allRooms.push(
        { 
          roomId: i,
          roomName: `room${i}`,
          roomDescription: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
          roomType: "DELUXE",
          roomCapacity: 3,
          CreatorId: i,
          CreatorName: `user ${i}`,
          roomMainImgSrc: "https://images.unsplash.com/photo-1551882547-ff40c63fe5fa?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        },
      )
    }
    this.rooms.set(allRooms);
  }

  onCheckAvailability(currentRoomId: Number){
    this.isAvailable='CHECKED';
    console.log(this.startDate.value);
    console.log(this.endDate.value);
    console.log(currentRoomId);
    if(this.startDate.value == "" || this.endDate.value == ""){
      this.chkAvailabilityError="Please fill dates"
      return ;
    }
    const d1 = this.startDate?.value;
    const d2 = this.endDate?.value;
    if(d1 && d2 && (new Date(d1) > new Date(d2))){
      this.chkAvailabilityError="End Date can't be before start Date";
      return ;
    }
    this.isAvailable = 'NOT_AVAILABLE';

    //TODO: check for availability through api and finalize
    if(true){
      this.isAvailable = 'AVAILABLE';
    }else{
      this.chkAvailabilityError = "Room is not available";
    }
  }

  onDateBasedFilter(){
    console.log(this.filterStartDate);
    console.log(this.filterStartDate);
    //TODO: fetch on available rooms and update the signal that reflects in the view.
    this.rooms.set([...this.rooms().slice(2,5)]);
  }

  
  onClearDateFilter(){
    this.getRooms();
  }


}
