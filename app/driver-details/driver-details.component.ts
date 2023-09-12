import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DriverService } from '../driver.service';
import { Driver } from '../driver';

@Component({
  selector: 'app-driver-details',
  templateUrl: './driver-details.component.html',
  styleUrls: ['./driver-details.component.css']
})
export class DriverDetailsComponent implements OnInit {


  
  driverId: number = 0;
  driver: any = [];
  constructor(private route: ActivatedRoute,private router:Router, private driverService: DriverService) { }

  ngOnInit(): void {
    this.driverId = this.route.snapshot.params['driverId'];

    this.driver = new Driver();
    this.driverService.getDriverDetailsById(this.driverId).subscribe( data => {
      this.driver = data;
    });
  }

   home(){
       this.router.navigate(['driver']);
   }


 

  
}

