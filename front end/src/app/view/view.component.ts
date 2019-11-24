import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';
import { Router } from '@angular/router';
import { Vendor } from '../vendor';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent implements OnInit {

  details: Vendor[];
  searchString=new Vendor();
  adds = new Vendor();
  
  constructor(private router:Router,private loginservice:LoginService) { }

  ngOnInit() {
    this.viewAllDetails();
  }
  add(vendorId:number):void{
    this.router.navigate(['/edit/'+vendorId]);
  }

  addDet():void{
    this.router.navigate(['/add']);
  }
 
  goBack():void{
    this.router.navigate(['/'])
}

  viewAllDetails(): void{
    this.loginservice.getAllDetails().subscribe((detailData) =>{
      this.details=detailData,
      console.log(detailData);
    }, 
    (error) =>{
      console.log(error);
    });
  }

searchVendor(search:string):void{
  if(search!=null){
    this.loginservice.searchVendor(search).subscribe((detailData) =>{
      this.details=detailData,
      console.log(detailData);
  }, 
  (error) =>{
    console.log(error);
  });
  
}
else{
  this.viewAllDetails();
}

}


disableVendor(vendorId:number):void{
 console.log("Disable");
    this.loginservice.disableVendor(vendorId)
    .subscribe((disableData) =>{
this.adds=disableData

this.viewAllDetails();
     }, (error) =>{
      console.log(error);
     });
 }



}
