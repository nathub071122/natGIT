import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup ;

  constructor(private formBuilder: FormBuilder, private router:Router) { }

  onSubmit(): void {
    console.log("logging .......");
    console.log(this.loginForm.value);
    const loginid: string = this.loginForm.controls['loginid'].value;
    const password: string = this.loginForm.controls['password'].value;

    // use the authentication service, which in turn accesses the RESTAPI exposed by the LoginMicroservice.
    if(loginid == 'user' && password =='pass'){
      sessionStorage.setItem("loggedIn",'yes')
      // navigate dynamically through the code to another component
      this.router.navigate(['employees']);
    }
    else 
    {
      this.loginForm.controls['loginid'].setValue("");
      this.loginForm.controls['password'].setValue("");
    }
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      loginid: ['user'],
      password: []
    });
  }
}
