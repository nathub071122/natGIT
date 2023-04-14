import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
// AuthGurad to guard the routes
export class AuthGuardService implements CanActivate {

  constructor(private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> |
    Promise<boolean | UrlTree>{
    if (sessionStorage.getItem('loggedIn') == 'yes') {
      return true;
    }
    this.router.navigate(['/login'])
    return false;
  }

}
