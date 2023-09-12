import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BusDetailsComponent } from './bus-details/bus-details.component';
import { CreateBusComponent } from './create-bus/create-bus.component';
import { BusListComponent } from './bus-list/bus-list.component';
import { UpdateBusComponent } from './update-bus/update-bus.component';
import { NavbarComponent } from './sharepage/navbar/navbar.component';
import { FooterComponent } from './sharepage/footer/footer.component';
import { HomeComponent } from './pages/home/home.component';
import { MenuComponent } from './pages/menu/menu.component';
import { ContactComponent } from './pages/contact/contact.component';
import { AboutComponent } from './pages/about/about.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';
import { BookbusComponent } from './bookbus/bookbus.component';
import { UserListComponent } from './user-list/user-list.component';
import { SignupComponent } from './signup/signup.component';
import { AdminComponent } from './admin/admin.component';
import { DriverListComponent } from './driver-list/driver-list.component';
import { DriverDetailsComponent } from './driver-details/driver-details.component';
import { CreateDriverComponent } from './create-driver/create-driver.component';
import { UpdateDriverComponent } from './update-driver/update-driver.component';

@NgModule({
  declarations: [
    AppComponent,
    BusDetailsComponent,
    CreateBusComponent,
    BusListComponent,
    UpdateBusComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    MenuComponent,
    ContactComponent,
    AboutComponent,
    LoginComponent,
    LogoutComponent,
    FeedbackComponent,
    BookbusComponent,
    UserListComponent,
    SignupComponent,
    AdminComponent,
    DriverListComponent,
    DriverDetailsComponent,
    CreateDriverComponent,
    UpdateDriverComponent,
   
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule,
    NgbDropdownModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }