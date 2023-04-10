:one: _Main (main.ts)_  

```ts
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {AppModule} from './app/app.module';
platformBrowserDynamic().bootstrapModule(AppModule).catch(err => console.log(err));
```


:two: _AppModule (app.module.ts)_  
```ts
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
@NgModule({
 imports : [
    BrowserModule
 ],
 declarations:[
    AppComponent
 ],
 bootstrap : [
    AppComponent
 ]
})
export class AppModule {

}
```
:three: _AppComponent_  
```ts
import {Component} from '@angular/core';
@Component({
    selector : 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css]
})
export class AppComponent {

}
```

:four: _index.html_
```html
<body>
<app-root></app-root>
</body>
```
:five: _create data for pdoructs_  
```ts

// javascript with types
export interface Product {
    id:number;
    name:string;
    price:number;
    description:string;
}

exprot const products = [
 {
    id: 1,
    name: 'Phone XL',
    price: 799,
    description: 'A large phone with one of the best screens'
  },
  {
    id: 2,
    name: 'Phone Mini',
    price: 699,
    description: 'A great phone with one of the best cameras'
  },
  {
    id: 3,
    name: 'Phone Standard',
    price: 299,
    description: ''
  }
];
```
