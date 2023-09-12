import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BusService } from '../bus.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent {
  constructor(private route: ActivatedRoute, private busService: BusService,private router: Router) { }
 

  feedback(){
    var status = confirm("FeedBack sent Succefully!!");
    this.router.navigate(['']);
  }
  }

