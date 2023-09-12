import { Component, OnInit } from '@angular/core';
import { BusService } from '../bus.service';
import { Bus } from '../bus';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-bus',
  templateUrl: './update-bus.component.html',
  styleUrls: ['./update-bus.component.css']
})
export class UpdateBusComponent implements OnInit {

  busId: number = 0;
  bus: Bus = new Bus();
  constructor(private busService: BusService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.busId = this.route.snapshot.params['busId'];
    this.busService. getBusById(this.busId).subscribe(data => {
      this.bus = data;
      console.log(data);
    }, error => console.log(error));
  }

  onSubmit(){
    console.log(this.busId);
    console.log(this.bus);
    this.busService.updatebusDetailsById(this.busId, this.bus).subscribe( data =>{
      this.goToBusList();
    }
    , error => console.log(error));
  }

  goToBusList(){
    this.router.navigate(['/bus']);
  }
  home(){
    this.router.navigate(['bus']);
  }
}