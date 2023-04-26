import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm?: FormGroup;
  submitted = false;
  constructor(private formBuilder: FormBuilder, private router : Router) { }
  ngOnInit(): void {
    // const emailPattern = "";
    const phoneNumberPattern = "^((\\+65-?)|0)?[0-9]{10}$";
    this.registerForm = this.formBuilder.group({
      adminName : ['Bruce Lee',[Validators.required,Validators.minLength(5),Validators.maxLength(20)]],
      email: ['bruce@lee.com'],
      phone: ['1212121212',[Validators.required]],
      password:['',Validators.required, Validators.minLength(6)]
    })
  }
  onSubmit() {
    this.submitted = true;
    // if the form is valid, store it in the backend else cancel submission
    if(this.registerForm.invalid){
      console.log("Invalid details, form data not submitted!");
      console.log( JSON.stringify(this.registerForm.value));
      return;
    }
    console.log('Registered Successfully :-) ' + JSON.stringify(this.registerForm.value));
    this.router.navigate(['login']);
  }

  get rfc() {
    return this.registerForm.controls;
  }
}

