import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { VendorContact } from '../vendorContact';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddVendorService {

  constructor(private _httpService:HttpClient) { }

  addVendor(vendor: VendorContact){
    let body = JSON.stringify(vendor);
    let headers= new HttpHeaders({'Content-Type':'application/json'});
    let options= { headers: headers }
    console.log(vendor.vId);
    if(vendor.vId!=0)
    {
      return this._httpService.put(environment.APIUrl +'/insert',body,options);
    }
    else
    {
      return this._httpService.post(environment.APIUrl +'/insert',body,options);
    }
    
  }

  getVendorById(vId: string): Observable<VendorContact>{
    return this._httpService.get<VendorContact>(environment.APIUrl+'/'+vId);
    
  }
}
