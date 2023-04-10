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
