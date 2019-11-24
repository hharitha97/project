import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';
import { Router } from '@angular/router';
import { Vendor } from '../vendor';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.scss']
})
export class AddComponent implements OnInit {

  add = new Vendor();

  constructor(private router:Router,private loginservice:LoginService) { }

  ngOnInit() {
   // this.addVendor();
    //this.goback();
  }


  addVendor(): void{
 
    this.loginservice.addDetails(this.add)
      .subscribe((response)=>{ 
        console.log(response);
       // this.reset();
        this.router.navigate(['/view']);
      }, (error)=>{

        console.log(error);
      });
  }

  

  goback():void{
     this.router.navigate(['/view'])
 }

  // private reset()
  // {
  //   this.add.vendorId=null;
  //  this.add.vendorName=null;
  //   this.add.address=null;
  //   this.add.location=null;
  //   this.add.service=null;
  //   this.add.pinCode=null;
  //   this.add.vendorStatus=null;
  //   this.add.contactId=null;
  //   this.add.contactName=null;
  //   this.add.department=null;
  //   this.add.email=null;
  //   this.add.phone=null;
  // }

}
