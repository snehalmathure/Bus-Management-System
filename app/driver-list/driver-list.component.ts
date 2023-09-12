import { Component, OnInit } from '@angular/core';
import { Driver } from '../driver';
import { DriverService } from '../driver.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-driver-list',
  templateUrl: './driver-list.component.html',
  styleUrls: ['./driver-list.component.css']
})
export class DriverListComponent implements OnInit {

  drivers: Driver[] = [];
 
  Name: string="";
  pageNo: number = 1;
  count: number = 5;
 
  constructor(private driverService: DriverService,
    private router: Router) { }

  ngOnInit(): void {
    this.getDriver();
  }

  private getDriver(){
    this.driverService.getDriverList().subscribe(data => {
      this.drivers = data;

      //int num[]
      //int num1[]
      //num = num1
    });
  }

  updateDriver(driverId: number){
    console.log(driverId)
    this.router.navigate(['update-driver',driverId]);
  }

  deleteDriver(driverId: number){
    var status = confirm("Are you sure to delete record?");
    console.log(driverId)
    this.driverService.deleteDriverById(driverId).subscribe( data => {
      console.log(data);
      this.getDriver();
    })
  }

 

  driverDetails(busId: number){
    this.router.navigate(['driver-details',busId]);
  }
  
  


  
 

  
   
  //  getBusDetailsBydriverName(){
  //   this.driverService.findByDriverName(this.Name).subscribe(details =>{
      
  //     console.log('Response from service:',details);
  //      this.buses= details;
  //   },
  //       error => {
  //         console.log(error);
  //      });
  //  }

   

home(){
  this.router.navigate(['']);
}
}