import {
  Component,
  OnInit,
  WritableSignal,
  inject,
  signal,
} from '@angular/core';
import { ListBookingsComponent } from '../list-bookings/list-bookings.component';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [ListBookingsComponent, CommonModule, ReactiveFormsModule],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css',
})
export class ProfileComponent implements OnInit {
  route = inject(ActivatedRoute);
  currentUserId: String | null = null;
  currentUserProfile: WritableSignal<any> = signal({}); //TODO: Later declare the profile type
  //For booking button
  showBookings = false;
  bookingButtonText = "My Bookings";
  //For update button
  showUpdateForm = false;
  updateButtonText="Update";
  // update form
  updateUserForm = new FormGroup(
    {
      username: new FormControl(this.currentUserProfile().username, Validators.required),
      firstname: new FormControl(this.currentUserProfile().firstName, Validators.required),
      lastname: new FormControl(this.currentUserProfile().lastName, Validators.required),
      phone: new FormControl(this.currentUserProfile().phone, Validators.required)

    }
  )

  ngOnInit(): void {
    this.route.paramMap.subscribe(
      (params) => (this.currentUserId = params.get('userId'))
    );
    this.getProfile(this.currentUserId);

    this.updateUserForm.patchValue(
      {
        username: this.currentUserProfile().username,
        firstname: this.currentUserProfile().firstName,
        lastname: this.currentUserProfile().lastName,
        phone: this.currentUserProfile().phone

      }
    )
  }

  getProfile(userId: String | null) {
    let currentUserProfile = {};
    if (userId == null) {
      return ;
    }
    //TODO:  get the profile using api
    this.currentUserProfile.set({
      userId: 2,
      username: 'hemu2',
      firstName: 'hemanth',
      lastName: 'duddu',
      email: 'd@3.com',
      phone: '9993338881',
      bookings: {
        current: [],
        previous: [],
        upcoming: [
          {
            bookingId: 3,
            bookingDate: '2024-08-04T22:30:03.552065',
            startDate: '2024-08-27',
            endDate: '2024-08-29',
            roomIdsNamesMap: {
              '1': 'Gmu Motel',
              '2': 'GM Motel',
            },
            customerId: 2,
            customerName: 'hemanth duddu',
          },
        ],
      },
      rooms: {},
    });
  }

  toggleBookings(){
    if(this.showUpdateForm){
      this.toggleUpdateForm();
    }
    this.showBookings = !this.showBookings
    this.bookingButtonText = "Back";
    if(!this.showBookings){
      this.bookingButtonText="My Bookings";
    }
  }

  toggleUpdateForm(){
    if(this.showBookings){
      this.toggleBookings();
    }
    this.showUpdateForm = !this.showUpdateForm
    this.updateButtonText = "Back";
    if(!this.showUpdateForm){
      this.updateButtonText="Update";
    }
  }
}
