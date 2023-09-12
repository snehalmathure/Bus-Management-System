import { Component, OnInit } from '@angular/core';
import { Driver } from '../driver';
import { DriverService } from '../driver.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-driver',
  templateUrl: './update-driver.component.html',
  styleUrls: ['./update-driver.component.css']
})
export class UpdateDriverComponent implements OnInit{

  driverId: number = 0;
  driver: Driver = new Driver();
  constructor(private driverService: DriverService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.driverId = this.route.snapshot.params['driverId'];
    console.log(this.driverId);
    this.driverService. getDriverDetailsById(this.driverId).subscribe(data => {
      this.driver = data;
    }, error => console.log(error));
  }

  onSubmit(){
    console.log(this.driverId);
    console.log(this.driver);
    this.driverService.updateDriverDetailsById(this.driverId, this.driver).subscribe( data =>{
      this.goToDriverList();
    }
    , error => console.log(error));
  }

  goToDriverList(){
    this.router.navigate(['driver']);
  }
  home(){
    this.router.navigate(['driver']);
  }

}

