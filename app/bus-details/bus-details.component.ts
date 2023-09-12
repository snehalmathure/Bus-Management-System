import { Component, OnInit } from '@angular/core';
import { Bus } from '../bus';
import { ActivatedRoute, Router } from '@angular/router';
import { BusService} from '../bus.service';


@Component({
  selector: 'app-bus-details',
  templateUrl: './bus-details.component.html',
  styleUrls: [ './bus-details.component.css']
})
export class BusDetailsComponent implements OnInit {

  busId: number = 0;
  bus: any = [];
  constructor(private route: ActivatedRoute, private busService: BusService,private router: Router) { }

  ngOnInit(): void {
    this.busId = this.route.snapshot.params['busId'];
    console.log(this.busId);
    this.bus = new Bus();
    this.busService.getBusById(this.busId).subscribe( data => {
      this.bus = data;
    });
  }
  home(){
    this.router.navigate(['bus']);
  }

  
  book(busId: number){
    this.router.navigate(['bookbus',busId]);
  }

}