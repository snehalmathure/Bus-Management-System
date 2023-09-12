import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { BusService } from '../bus.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  user: User[]=[];
  pageNo: number = 1;
  count: number = 5;
  busId:number=0;
  userID:number=0;
 

  constructor(private  userService: UserService,
    private route: ActivatedRoute,
    private router: Router,
    private cdRef:ChangeDetectorRef) { }

  ngOnInit(): void {
    this.busId = this.route.snapshot.params['busId'];
    
    
  this.userService.getUsersByBusId(this.busId).subscribe(data=>{
    console.log(data);
    this.user=data;
    this.getUser();
  
    });
  }
    private getUser(){
      this.userService.getUserList().subscribe(data => {
        this.user = data;
  
      
      });
    
  }
  deleteUser(userID: number){
    var status =  confirm("Are you sure to delete this records?");
    if(status == true){
    console.log(userID)
    this.userService.deleteUserById(userID).subscribe( data => {
      console.log(data);
      this.getUser();
    },
      
    error => {
      console.log(error);

    })
  }
  else{
    this.getUser();
  }

  }
 
 
  back(){
    this.router.navigate(['bus']);
  }


}

