import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ListVendorsComponent } from './list-vendors/list-vendors.component';
import { AddVendorComponent } from './add-vendor/add-vendor.component';
import { HttpClientModule } from '@angular/common/http';
import { AuthGuard } from './guards/auth.guard';
import {NgxPaginationModule} from 'ngx-pagination';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListVendorsComponent,
    AddVendorComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule,

  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
