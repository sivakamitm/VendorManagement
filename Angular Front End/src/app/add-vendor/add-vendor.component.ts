import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AddVendorService } from './add-vendor.service';
import { ListVendorsService } from '../list-vendors/list-vendors.service';
import { VendorContact } from '../vendorContact';

@Component({
  selector: 'app-add-vendor',
  templateUrl: './add-vendor.component.html',
  styleUrls: ['./add-vendor.component.scss']
})
export class AddVendorComponent implements OnInit {

  constructor(private router:Router, private _addVendor:AddVendorService,private route:ActivatedRoute,private _viewVendor:ListVendorsService) { 
    
  }

  vendor=new VendorContact();
  ngOnInit() {
    this.route.params.subscribe( params=>this.getVendorById(params['vId']));
  }


  addVendor():void{
    this._addVendor.addVendor(this.vendor).subscribe((vendors)=>{
    console.log(vendors);
    this.reset();
    //this.addvendor();
    this.router.navigate(['/ListVendors']);
  },(error)=>{console.log(error);});
}

private reset(){
  this.vendor.vId = null;
  this.vendor.vendorName = null;
  this.vendor.address=null;
  this.vendor.location= null;
  this.vendor.service=null;
  this.vendor.pincode= null;
  this.vendor.cName=null;
  this.vendor.department= null;
  this.vendor.email=null;
  this.vendor.phone= null;
}

getVendorById(vId: string)
{
console.log(vId);
this._addVendor.getVendorById(vId).subscribe((vendorData)=>{
  this.vendor=vendorData;
  console.log(vendorData);
},(error)=>{
  console.log(error);
});
}


updatevendor():void{
this._addVendor.addVendor(this.vendor).subscribe((ven)=>{
  console.log(ven);
  this.router.navigate(['/Listvendors']);
},(error)=>{
  console.log(error);
});

}

Logout()
{
  this.router.navigate(['/Logout']);
}

}
