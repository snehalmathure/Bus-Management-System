import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationServiceService } from 'src/app/authentication-service.service';
import { BusService } from 'src/app/bus.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

   

  constructor(public loginService:AuthenticationServiceService,
    private router: Router) { }
 
 
 login(){
  this.router.navigate(['login']);
 }
}
