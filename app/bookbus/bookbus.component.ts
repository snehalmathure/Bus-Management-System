import { Component, OnInit } from '@angular/core';
import { Bus } from '../bus';
import { ActivatedRoute, Router } from '@angular/router';
import { BusService} from '../bus.service';
import { UserService } from '../user.service';
import { User } from '../user';
import { EmailService } from '../email.service';



@Component({
  selector: 'app-bus-details',
  templateUrl: './bookbus.component.html',
  styleUrls: [ './bookbus.component.css']
})
export class BookbusComponent implements OnInit {

  busId: number = 0;
  userEmail:string="";
  user: User = new User();
  formatedDate!:string;
  bus:Bus=new Bus();

  constructor(private userService: UserService,
    private busService: BusService,
    private emailService:EmailService,
    
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.busId = this.route.snapshot.params['busId'];
    
console.log(this.busId);

    };
     
    goToBusList(){
      this.router.navigate(['/bus']);
    }

    addBooking() {
     this.userService.addBooking(this.user, this.busId).subscribe(data=>{

      console.log(data);
      var status = confirm("Booking Confirmed");
   
     },
     error=>console.log(error));
    }
  

    mailchecking(){
     
      this.bus = new Bus();
    
      this.busService.getBusById(this.busId).subscribe( data => {
        this.bus = data;
        console.log(data);
      });
        this.emailService.checkEmail(this.user.userEmail, this.bus).subscribe(data => {
          console.log(data);
       // this.goToBusList();
        },
        error => console.log(error));
     
    }
  
    onSubmit(){
      this.addBooking();
      console.log("add user data to the user table... booking sucesful mail should to gooo");
      console.log(this.user.userEmail);
      if (this.user.userEmail) {
        this.mailchecking();
  
      } else {
        console.log('userEmail is null, cannot make API request.');
      }
    }
 
  
  
  back(){
    this.router.navigate(['bus-details/busId']);
  }
}
