import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from './login.service';
import { Vendor } from '../vendor';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  login=new Vendor();
  logins:Vendor[];
  message:string;


  constructor(private route:ActivatedRoute,private router:Router,private Service:LoginService) { }

  ngOnInit() {
  }

  

  validLogin(form:NgForm){
    this.Service.getRoleId(form.value).subscribe(data=>{
      console.log(data);
      this.login=data;
      
     
       console.log(this.login);
        
        if(this.login.userId==1){
          console.log(data.username);
          this.router.navigate(['view']);
        }
        else if(this.login.userId==2){
          console.log(data.username);
          this.router.navigate(['view']);
        }
        
        
        else{
          this.message="Incorrect username or password";
        }
      },
      (error) =>{
        console.log(error);
      });
      }

      
}
