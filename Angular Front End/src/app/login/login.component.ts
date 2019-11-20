import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from './login.service';
import { Router } from '@angular/router';
import { Login } from '../login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private router:Router,private loginService:LoginService) { }
  ustLogin= new Login();
  userId: number;
  sessionTokenUserName:string;
  sessionTokenRoleId:string;
  message:string;
  ngOnInit() {
  }

  OnSubmit(form:NgForm){
    
    this.validLogin(form);
    this.sessionTokenUserName=localStorage.getItem('token');
    console.log(this.sessionTokenUserName=localStorage.getItem('token'));
    this.sessionTokenRoleId=localStorage.getItem('tokenRoleId');
  }

  validLogin(form:NgForm){
    console.log(form.value);
    this.loginService.getLogin(form.value).subscribe(data=>{
    this.ustLogin=data;
    localStorage.setItem('isLoggedIn', "true");
      localStorage.setItem('token', data.roleName);
      localStorage.setItem('tokenRoleId', data.roleId);
    console.log(this.ustLogin);
   if(this.ustLogin.userId!=0)
  {
    this.router.navigate(['/ListVendors']);
  }
  else
  {     this.message="Invalid username and password";
        this.router.navigate(['/Login']);
  } 
},
(error) =>{
  console.log(error);
});
}


Logout()
{
  this.router.navigate(['/Logout']);
}

}
