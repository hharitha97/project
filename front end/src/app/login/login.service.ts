import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Vendor } from '../vendor';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
formData:Vendor

  constructor(private _httpService:HttpClient,private _router:Router) { }

  getRoleId(formData:any):any{
    return this._httpService.get<Vendor>(environment.APIUrl+'/login/'+formData.username+'/'+formData.password);
  }

  getAllDetails(): Observable<Vendor[]>{
    return this._httpService.get<Vendor[]>(environment.APIUrl +'/viewlist');
  }

  addDetails(add:Vendor)
  {
    let body = JSON.stringify(add);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }

    if(add.vendorId){

      return this._httpService.put(environment.APIUrl +'/insertDetails',body,options);
    }else{
      return this._httpService.post(environment.APIUrl +'/insertDetails',body,options);
    }
  }

  getVendorById(vendorId:number):Observable<Vendor>{
    return this._httpService.get<Vendor>(environment.APIUrl +'/getById/'+vendorId);
  }

searchVendor(search:string):Observable<Vendor[]>{
  return this._httpService.get<Vendor[]>(environment.APIUrl +'/find/'+search);
}



// disableVendor(v: Vendor){
//   let body=JSON.stringify(v);
//   let headers=new HttpHeaders({'Content-Type':'application/json'});
//   let options={headers:headers}
//   return this._httpService.put(environment.APIUrl+'/disablevendor/',body,options);
// }

disableVendor(vendorId:number):Observable<Vendor>{
  let body=JSON.stringify(vendorId);
     let headers=new HttpHeaders({'Content-Type':'application/json'});
   let options={headers:headers}
   return this._httpService.put<Vendor>(environment.APIUrl+'/disablevendor/'+vendorId,body,options);
}

}
