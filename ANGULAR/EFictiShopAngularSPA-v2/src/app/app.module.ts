import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing-module';

import { AppComponent } from './app.component';
import { ListEmpComponent } from './list-emp/list-emp.component';


@NgModule({
  declarations: [	
    AppComponent,
    ListEmpComponent,

   ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
