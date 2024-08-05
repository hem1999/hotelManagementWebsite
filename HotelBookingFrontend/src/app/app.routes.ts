import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { ListBookingsComponent } from './list-bookings/list-bookings.component';
import { RoomsComponent } from './rooms/rooms.component';
import {AppComponent} from './app.component'
import { ProfileComponent } from './profile/profile.component';

export const routes: Routes = [
    // {
    //     path:"",
    //     component: AppComponent
    // },
    {
        path:"login",
        component: LoginComponent

    },
    {
        path: "signup",
        component: RegistrationComponent
    },
    {
        path: "rooms",
        component: RoomsComponent
    },
    {
        path: "bookings/:userId",
        component: ListBookingsComponent
    },
    {
        path: "profile/:userId",
        component: ProfileComponent
    }
];
