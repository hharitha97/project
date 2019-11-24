import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Vendor } from '../vendor';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {

  add = new Vendor();
  constructor(private route: ActivatedRoute,private router:Router,private loginservice:LoginService) { }

  ngOnInit() {
    this.route.params.subscribe( params => this.getById(params['vendorId']));
  }

  editVendor(): void{
    this.loginservice.addDetails(this.add)
      .subscribe((response) =>{
        console.log(response);
       this.router.navigate(['view']);
      },(error) =>{console.log(error);
      });
  }

  goback():void{
    this.router.navigate(['/view'])
}

  getById(vendorId: number){
   
    this.loginservice.getVendorById(vendorId)
    .subscribe((searchData) =>{
      this.add=searchData;
      console.log(searchData);
    }, (error) =>{
      console.log(error);
    });
  }


}
