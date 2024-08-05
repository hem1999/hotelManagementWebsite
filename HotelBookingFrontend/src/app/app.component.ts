import { Component } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { Router, RouterLink,RouterOutlet } from '@angular/router';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ReactiveFormsModule, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'hotelFrontend';
  userid = 2; //TODO: later manage it through the authService.
  notLoggedIn=false;
  showProfileMenu=false;
  toggleShowMyProfileMenu(){
    this.showProfileMenu = !this.showProfileMenu;
  }
}
