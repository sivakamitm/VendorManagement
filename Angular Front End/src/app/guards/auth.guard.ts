import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private router: Router) { }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if (this.isLoggedIn())
      {
        return true;
      }
      this.router.navigate(['/Login']);
      return false;
    }
    public isLoggedIn(): boolean {
      let status = false;
     // var localStorage: Storage
      if(localStorage.getItem('isLoggedIn') == "true"){
        status = true;
      }
      else{
        status = false;
      }
      return status;
    }
  }
  
