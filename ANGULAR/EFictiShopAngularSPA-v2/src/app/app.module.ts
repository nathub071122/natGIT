import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing-module';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ListEmpComponent } from './list-emp/list-emp.component';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [	
    AppComponent,
    ListEmpComponent,
    LoginComponent,

   ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
