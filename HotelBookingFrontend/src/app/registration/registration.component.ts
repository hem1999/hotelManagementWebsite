import { Component } from '@angular/core';
import { FormGroup, ReactiveFormsModule, FormControl} from '@angular/forms';

@Component({
  selector: 'app-registration',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent {

  signUpForm = new FormGroup(
    {
      username: new FormControl(''),
      firstName: new FormControl(''),
      lastName: new FormControl(''),
      email: new FormControl(''),
      password: new FormControl(''),
      streetAddress:new FormControl(''),
      city:new FormControl(''),
      zip:new FormControl(''),
      state:new FormControl(''),
      userType:new FormControl(''),
    }
  )

  onClickSignup(){
    //form submission successful!
    //navigate to Login
  }
}
