
:beginner: _**Lab 9:30 - 10:30**_ 

- Perform form-based authentication with a user and password

:beginner: _**Code base for Reference**_  

:point_right: Controller for Authentication  



```java
	@GetMapping("/users/{email}/{pass}")
	public ResponseEntity<Boolean> authenticate(@PathVariable(value="email") String email, @PathVariable(value="pass")String pass) {
		
		try {
			System.out.print("entered the user controller");
			return new ResponseEntity<>(userService.isValidUser(email, pass), HttpStatus.OK);
		} catch (EmailNotFoundException e) {
			System.out.print("entered the user controller: caught the invalid email exception");
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}catch(PasswordNotMatchedException e) {
			System.out.print("entered the user controller: caught the invalid password exception");
			 return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
```

:point_right: Authentication Service  

```ts
// AuthenticationService
  authenticateUser(email:string,  password:string){
      return this.httpClient.get<Observable<Boolean>>(this.baseUrl+"/"+email+"/"+password); 
  }

```

:point_right: Component TS code

```ts
        this.authenticationService.authenticateUser(this.f['userEmail'].value, this.f['password'].value).subscribe(
          // status here a custom variable that is returned by the end-point. 
          (status) => {
                console.log("authenticatiuon status:", status);
                //if authhenticated, navigate to movies component
                if (status) {
                    this.form.reset;
                    sessionStorage.setItem("loggedIn", 'yes')
                    // this.loggedIn = true;
                    this.router.navigate(['movies']);
                }

            }, (error: HttpErrorResponse) => {
                this.loading = false;
                if (error instanceof HttpErrorResponse) {

                    if (error.status === 400) {
                        this.f['userEmail'].setErrors({ userNotRegistered: true });
                        return;
                    } else if (error.status === 406) {
                        this.f['password'].setErrors({ invalidPassword: true });
                        return;
                    }
                }  
                alert("There is a problem with the service.Unable to connect to server. We are notified & working on it. Please try again later.");
                
            });
```



==========================

:beginner: _**Eloborate code**_  

```java
package com.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.User;
import com.demo.exceptions.EmailAlreadyInUseException;
import com.demo.exceptions.EmailNotFoundException;
import com.demo.exceptions.PasswordNotMatchedException;
import com.demo.exceptions.PhoneAlreadyInUseException;
import com.demo.exceptions.PhoneNotFoundException;
import com.demo.service.UserService;


@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = null;
		try {
			System.out.print("User being added: "+user);
			return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
			
		}catch (EmailAlreadyInUseException ex){
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}catch(PhoneAlreadyInUseException  ex) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

    // baseUrl: string = "http://localhost:8080/api/users"; //end point 
// /users/itsmymail@gmail.com/test
	@GetMapping("/users/{email}/{pass}")
	public ResponseEntity<Boolean> authenticate(@PathVariable(value="email") String email, @PathVariable(value="pass")String pass) {
		
		try {
			System.out.print("entered the user controller");
			return new ResponseEntity<>(userService.isValidUser(email, pass), HttpStatus.OK);
		} catch (EmailNotFoundException e) {
			System.out.print("entered the user controller: caught the invalid email exception");
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}catch(PasswordNotMatchedException e) {
			System.out.print("entered the user controller: caught the invalid password exception");
			 return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/users/checkEmail/{email}")
	public ResponseEntity<Boolean> emailInUse(@PathVariable(value="email") String email)  {
		
		try{
			return new ResponseEntity<>(userService.emailInUse(email), HttpStatus.OK);
		}catch(EmailNotFoundException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/users/checkPhone/{phone}")
	public ResponseEntity<Boolean> phoneInUse(@PathVariable(value="phone") String phone) {
		try{
			return new ResponseEntity<>(userService.phoneInUse(phone), HttpStatus.OK);
		}catch(PhoneNotFoundException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/users/checkPassword/{email}/{pass}")
	public Boolean isValidPassword(@PathVariable(value="email") String email, @PathVariable(value="pass")String pass) {
		System.out.print(email+ " "+ pass);
		return userService.isValidPassword(email, pass);
	}
}

```


```js
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, observable, throwError } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})

export class AuthenticationService {



  baseUrl: string = "http://localhost:8080/api/users"; //end point 
  constructor(private httpClient:HttpClient) {}
  
private handleError(errorResponse:HttpErrorResponse) {
  
  //if the HttpErrorResponse is an instance of ErrorEvent, then it means that a client-side or network error occurred. 
  if(! (errorResponse.error instanceof ErrorEvent))
  {
    console.log("Server side error:"+errorResponse.error.message);
    return throwError('There is a problem with the service.Unable to connect to server. We are notified & working on it. Please try again later.');
    
  }
  //otherwise,a server error occurred.
  else{
    console.log("client side error:"+errorResponse.error.message);
    return (errorResponse);
  }
  // returning a user friendly error message to the consumer of the service.
  


}
  //The service uses the RxJS Observable and Subject classes to enable communication with subscribers
  registerUser(user: User) {
    //post : new emp
    return this.httpClient.post(this.baseUrl, user);
  }

  authenticateUser(email:string,  password:string){
   
      return this.httpClient.get<Observable<Boolean>>(this.baseUrl+"/"+email+"/"+password);
      
     
  }
  signUp( user:User){
   return this.httpClient.post<User>(this.baseUrl,user);
  }

  //("/users/checkEmail/{email}")
  emailInUse(email:string){
    return this.httpClient.get<Boolean>(this.baseUrl+"/checkEmail/"+email);
    }
  phoneInUse(phone:string){
      return this.httpClient.get<Boolean>(this.baseUrl+"/checkPhone/"+phone);
    }

    isValidPassword(email:string,password:string){
      return this.httpClient.get<Boolean>(this.baseUrl+"/checkPassword/"+email+"/"+password);
    }
}

```

```ts


import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../service/authentication.service';
import { catchError, throwError } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';


@Component({ 
    templateUrl: 'login.component.html',
    styleUrls:['login.component.css']
})

/*The login component uses the authentication service to login to the application on form submit. 
It creates the form fields and validators using an Angular FormBuilder to 
create an instance of a FormGroup that is stored in the form property. 
The form is then bound to the <form> element in the login component template above using the [formGroup] directive.
*/
export class LoginComponent implements OnInit {
    form: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    authenticationStatus: Boolean;
    // loggedIn = false;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,

    ) { }

    ngOnInit() {
        this.form = this.formBuilder.group({
            userEmail: ['admin@gmail.com', Validators.required],
            password: ['pass', Validators.required]
        });
    }

    // The component contains a convenience getter property f to make it a bit easier to access form controls
    get f() { return this.form.controls; }

    
    //The login component uses the authentication service to login to the application on form submit.
    onSubmit() {
        this.submitted = true;
        this.loading = true;

        // stop here if form is invalid
        if (this.form.invalid) {
            this.loading = false; .
            return;
        }

        this.authenticationService.authenticateUser(this.f['userEmail'].value, this.f['password'].value).subscribe(
            (status) => {
                console.log("authenticatiuon status:", status);
                //if authhenticated, navigate to movies component
                if (status) {
                    this.form.reset;
                    sessionStorage.setItem("loggedIn", 'yes')
                    // this.loggedIn = true;
                    this.router.navigate(['movies']);
                }

            }, (error: HttpErrorResponse) => {
                this.loading = false;
                if (error instanceof HttpErrorResponse) {

                    if (error.status === 400) {
                        this.f['userEmail'].setErrors({ userNotRegistered: true });
                        return;
                    } else if (error.status === 406) {
                        this.f['password'].setErrors({ invalidPassword: true });
                        return;
                    }
                }  
                alert("There is a problem with the service.Unable to connect to server. We are notified & working on it. Please try again later.");
                
            });
    } 
}
```

```html
<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row justify-content-center align-baseline h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">User Login</h3>
            <form class="row g-3" [formGroup]="form" (ngSubmit)="onSubmit()">
              <div class="form-group">
                <label for="userEmail" class="form-label">User Email</label>
                <input type="text" formControlName="userEmail" class="form-control"
                  [ngClass]="{ 'is-invalid': submitted && f['userEmail'].errors }" />
                <div *ngIf="submitted && f['userEmail'].errors" class="invalid-feedback">
                  <div *ngIf="f['userEmail'].errors['required']">
                    User Email is required
                  </div>
                </div>
                
                <div *ngIf="submitted && f['userEmail'].errors" class="invalid-feedback">
                  <div *ngIf="f['userEmail'].errors['userNotRegistered']">
                    Not a registered Email.
                  </div>
                </div>

              </div>
              <div class="form-group">
                <label for="password" class="form-label">Password</label>
                <input type="password" formControlName="password" class="form-control"
                  [ngClass]="{ 'is-invalid': submitted && f['password'].errors }" />
               
                  <div *ngIf="submitted && f['password'].errors" class="invalid-feedback">
                    <div *ngIf="f['password'].errors['required']">
                      Password is required
                    </div>
                    <div *ngIf="f['password'].errors['invalidPassword']">
                      Invalid password
                    </div>
                  </div>
  
              </div>
              <div class="form-group">
                <button  class="btn btn-primary">
                  <span *ngIf="loading" class="spinner-border spinner-border-sm mr-1"></span>
                  Login
                </button>
                <a routerLink="../register-user" class="btn btn-link">Do not have an account?Register..</a>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>  
```

:loudspeaker: *httpClient.request*
```ts
this.httpClient.request('GET', URL);
this.httpClient.get(URL);
```

```js
Web is their home : IETF (W3C) : HTTP (GET,PUT,POST,DELETE) (Authority)
HTML,CSS (WHATWG), PROTOCOLS (IETF), WEB AUTHORITY IS (W3C)
```


```java
  @RequestMapping(method = RequestMethod.GET)
  //  @GetMapping  
```


