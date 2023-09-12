import { Component, OnInit } from '@angular/core';
import { Bus } from '../bus'
import { BusService } from '../bus.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-bus-list',
  templateUrl: './bus-list.component.html',
  styleUrls: ['./bus-list.component.css']
})
export class BusListComponent implements OnInit {

  buses: Bus[] = [];
  travelerName: string="";
  source : string = "";
  destination : string ="";
  driverName: string="";
  pageNo: number = 1;
  count: number = 5;
  selectedSearchType: string="";

  constructor(private busService: BusService,
    private router: Router) { }

  ngOnInit(): void {
    this.getBus();
  }

  private getBus(){
    this.busService.getBusList().subscribe(data => {
      this.buses = data;

      //int num[]
      //int num1[]
      //num = num1
    });
  }

  updateBus(busId: number){
    console.log(busId)
    this.router.navigate(['update-bus',busId]);
  }

  deleteBus(busId: number){
    var status = confirm("Are you sure to delete record?");
    console.log(busId)
    this.busService.deleteBusById(busId).subscribe( data => {
      console.log(data);
      this.getBus();
    })
  }

  bookingList(busId: number){
    console.log(busId)
    this.router.navigate(['user-list',busId]);
  }

  busDetails(busId: number){
    this.router.navigate(['bus-details',busId]);
  }
  
  removeAllBuses() : void{
    var status = confirm("Are you sure to delete all the records?");
    if (status == true) {
      this.busService.deleteAllBuses().subscribe(details => {
        console.log(details);
        this.getBus();
      },
        error => {
          console.log(error);
        })
    }
    else{
    this.getBus();
  }
  }



  getACBus() {
    this.busService.findByACDomain().subscribe({
      next: (bus1) => {
      console.log(bus1);
      this.buses = bus1;
    },
    error: (e) => console.error(e)
  });
  }

  getNonACBus(){
    this.busService.findByNonACDomain().subscribe({
      next: (bus1) => {
      console.log(bus1);
      this.buses = bus1;
    },
    error: (e) => console.error(e)
  });
  }

  search(selectedSearchType:string){
    if(this.selectedSearchType ==='travelerName'){
      this.searchtravelerName();
  } else if(this.selectedSearchType ==='sourceDestination'){
    this.getBusDetailsBySrcDest();
  }
}

  getBusDetailsBySrcDest(){
    this.busService.getBusDetailsBySoursecDestiation(this.source,this.destination).subscribe(details =>{
      
      console.log('Response from service:',details);
       this.buses= details;
    },
        error => {
          console.log(error);
       });
      
   }

   searchtravelerName() : any{
    this.busService.findBytravelerName(this.travelerName).subscribe(details => {
      this.buses= details;
      console.log(details);
    },
      error => {
        console.log(error);
      });
  }

   getBusDetailsBydriverName(){
    this.busService.findByDriverName(this.driverName).subscribe(details =>{
      
      console.log('Response from service:',details);
       this.buses= details;
    },
        error => {
          console.log(error);
       });
   }

   sortBy(sort: string): void {

    switch (sort) {
      case 'costLow':
        this.busService.sortByCost("asc","average_cost").subscribe(details => {
          console.log("Response from service:",details);
          this.buses=details;
        },
          error =>{
            console.log(error);
        
        });
          break;
       

      case 'costHigh':
        this.busService.sortByCost("desc","average_cost").subscribe(details => {
         console.log("Response from service:",details);
         this.buses=details; 
          },
        error =>{
        console.log(error);
    
    });
    
        break;

      case 'ratingLow':
        this.busService.sortByRatings("asc","ratings").subscribe(details => {
          console.log("Response from service:",details);
          this.buses=details;
        },
          error =>{
            console.log(error);
        
        });
          break;
        
        
        
      case 'ratingHigh':
        this.busService.sortByRatings("desc","ratings").subscribe(details => {
        console.log("Response from service:",details);
        this.buses=details;
    },
        error => {
        console.log(error);
    
    });
    
        break;
        default:
         break;
  }
}

home(){
  this.router.navigate(['']);
}
}