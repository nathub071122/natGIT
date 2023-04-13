:beginner: _**display the employees**_  

:one: _import HttpClientModule / app.module.ts_  
```ts
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

:two: _model/employee.model.ts_
```ts
export class Employee {
   id?: number;
   name?: string;
   salary?:number;
}

```
:three: _service/employee.service.ts_  
```ts
import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import {Employee} from '../model/employee.model'
// service shared by entire app
@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
   baseUrl : string = 'http://localhost:3000/employees'
  // Performs HTTP requests.
  constructor(private http: HttpClient) {
    
  }
  // returns Observable
  getEmployees() {
     return this.http.get<Employee[]>(this.baseUrl);
  }
}

```
:four: _app.component.ts_  
```ts
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './model/employee.model';
import { EmployeeService } from './service/employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'EFictiShopAngularSPA';
  employees?: Employee[];

  constructor(private employeeService : EmployeeService) {
  }

  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe(
      (data => {
        this.employees = data;
        console.log("DATA : " + data)
      })
    );
  }
}

```

:five: _app.component.html_  
```ts
<h1>Welcome to {{title}}</h1>
<div *ngFor="let employee of employees">
   {{employee.id}}
   {{employee.name}}
   {{employee.salary}}
</div>
```


  
