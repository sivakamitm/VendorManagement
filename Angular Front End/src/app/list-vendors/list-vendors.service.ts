import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { VendorContact } from '../vendorContact';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ListVendorsService {

  constructor(private _httpService:HttpClient) { }

  getAllVendor(): Observable<VendorContact[]>
  {
    return this._httpService.get<VendorContact[]>(environment.APIUrl+'/viewAll')
  }

  disableVendor(v: VendorContact){
    let body=JSON.stringify(v);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}
    return this._httpService.put(environment.APIUrl+'/disable',body,options);
  }

  SearchVendor(search: string): Observable<VendorContact[]>{
    return this._httpService.get<VendorContact[]>(environment.APIUrl+'/search/'+search);
  }

}
