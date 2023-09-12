import { Component } from '@angular/core';
import { AuthenticationServiceService } from 'src/app/authentication-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  constructor(public loginService:AuthenticationServiceService) { }

}
