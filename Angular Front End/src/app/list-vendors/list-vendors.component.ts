import { Component, OnInit } from '@angular/core';
import { ListVendorsService } from './list-vendors.service';
import { AddVendorService } from '../add-vendor/add-vendor.service';
import { Router } from '@angular/router';
import { VendorContact } from '../vendorContact';

@Component({
  selector: 'app-list-vendors',
  templateUrl: './list-vendors.component.html',
  styleUrls: ['./list-vendors.component.scss']
})
export class ListVendorsComponent implements OnInit {

  constructor(private router:Router,private _listVendor:ListVendorsService,private _addvendor:AddVendorService) { }

  ngOnInit() {
    this.getAllVendors();
  }

  vendor: VendorContact[];

  getAllVendors(): void{
    this._listVendor.getAllVendor()
    .subscribe((vendors) =>{
      this.vendor=vendors;    
      console.log(vendors);
    }, (error) =>{
      console.log(error);
    });
  }
   
  disableVendor(v: VendorContact){
    console.log("Disable");
      this._listVendor.disableVendor(v)
      .subscribe((response) =>{
        this.getAllVendors();
      }, (error) =>{
        console.log(error);
      });
  }

  editVendor(vId: string):void{

      console.log(vId);
      this.router.navigate(['/updateVendor/'+vId]);

  }

  AddVentor():void{

    this.router.navigate(['/AddVentor']);

}

  //medicine Search in Admin
  searchVendor(search: string): void{
    if (search!=null){
   this._listVendor.SearchVendor(search)
   .subscribe((medicineData)=>{
     //this.search=undefined;
     this.vendor=medicineData,
     console.log(this.vendor);
   }, (error) =>{
     console.log(error);
   });
 }else{
   this.getAllVendors();
 }
 }
 
}
