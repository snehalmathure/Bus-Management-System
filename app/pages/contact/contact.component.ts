import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BusService } from 'src/app/bus.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  constructor(private route: ActivatedRoute, private busService: BusService,private router: Router) { }
  raise_problem(){
    this.router.navigate(['menu']);
  
  }

}
