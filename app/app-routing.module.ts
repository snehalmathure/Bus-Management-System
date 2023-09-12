import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BusListComponent } from './bus-list/bus-list.component';
import {CreateBusComponent } from './create-bus/create-bus.component';
import { UpdateBusComponent } from './update-bus/update-bus.component';
import { BusDetailsComponent } from './bus-details/bus-details.component';
import { NavbarComponent } from './sharepage/navbar/navbar.component';
import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/about/about.component';
import { ContactComponent } from './pages/contact/contact.component';
import { MenuComponent } from './pages/menu/menu.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { SignupComponent } from './signup/signup.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { AuthGaurdServiceService } from './auth-gaurd-service.service';
import { AuthenticationServiceService } from './authentication-service.service';
import { BookbusComponent } from './bookbus/bookbus.component';
import { UserListComponent } from './user-list/user-list.component';
import { DriverDetailsComponent } from './driver-details/driver-details.component';
import { UpdateDriverComponent } from './update-driver/update-driver.component';
import { CreateDriverComponent } from './create-driver/create-driver.component';
import { DriverListComponent } from './driver-list/driver-list.component';


const routes: Routes = [
 {path: 'bus', component: BusListComponent, canActivate:[AuthGaurdServiceService]},
  {path: 'create-bus', component: CreateBusComponent, canActivate:[AuthGaurdServiceService]},
  //{path: '', redirectTo: 'bus', pathMatch: 'full'},
  {path:'update-bus/:busId',component:UpdateBusComponent, canActivate:[AuthGaurdServiceService]},
  {path: 'bus-details/:busId', component: BusDetailsComponent, canActivate:[AuthGaurdServiceService]},
  {path: '', component: HomeComponent},
  {path: 'menu', component: MenuComponent},
  {path: 'about', component: AboutComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent, },
  {path: 'feedback',component:FeedbackComponent},
  {path: 'bookbus/:busId',component:BookbusComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'user-list/:busId',component:UserListComponent,canActivate:[AuthGaurdServiceService]},
  {path:'signup',component:SignupComponent},
  {path: 'driver', component: DriverListComponent, canActivate:[AuthGaurdServiceService]},
  {path: 'create-driver', component: CreateDriverComponent, canActivate:[AuthGaurdServiceService]},
  {path:'update-driver/:driverId',component:UpdateDriverComponent, canActivate:[AuthGaurdServiceService]},
  {path: 'driver-details/:driverId', component: DriverDetailsComponent, canActivate:[AuthGaurdServiceService]},
  
  

  

 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
  exports: [RouterModule]
})
export class AppRoutingModule { }