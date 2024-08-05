import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  // *******This is for a simple emailSignup form or single input***********
  // loginEmail = new FormControl('');
  // loginPassword = new FormControl(''); 
  // // you use something like this.loginEmail.setValue(<pass the value>)
  // onClickLogin(){
  //   console.log(this.loginEmail);
  //   console.log(this.loginPassword);
  // }

  successfulLogin= true;
  constructor(private router: Router){
  }

  //*********Form Group*******
  loginForm = new FormGroup(
    {
      email: new FormControl('',Validators.required),
      password: new FormControl('',Validators.required)
    }
  )

  onClickLogin(){
    console.log(this.loginForm);
    //TODO: check the conditions and setup the succesfulLogin Property.
    if(this.successfulLogin){
      this.router.navigate(['rooms'])
    }
  }

}
