import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ListVendorsComponent } from './list-vendors/list-vendors.component';
import { AddVendorComponent } from './add-vendor/add-vendor.component';
import { AuthGuard } from './guards/auth.guard';


const routes: Routes = [

  {path: '', redirectTo: 'Login', pathMatch: 'full'},
  {path:'Login', component:LoginComponent},
  {path:'AddVentor', component:AddVendorComponent, canActivate : [AuthGuard]},
  {path:'updateVendor/:vId', component:AddVendorComponent, canActivate : [AuthGuard]},
  {path:'ListVendors', component:ListVendorsComponent, canActivate : [AuthGuard]},
  {path:'Logout', component:LoginComponent, canActivate : [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
