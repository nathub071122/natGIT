:beginner: _**Getting started with angular**_  

:point_right: ANGULAR  

- a TypeScript-based 
- free and open-source 
- web application framework
- used to create SPA [Single Page Application]
- by Google

:point_right: SPA
- A single-page application (SPA) is a web application or website 
- dynamically rewriting the current web page with new data from the web server
- instead of the default method of a web browser loading entire new pages.
- The goal is faster transitions that make the website feel more like a native app.

- a page refresh never occurs; 
- instead, all necessary HTML, JavaScript, and CSS code is either retrieved by the browser with a single page load
- or the appropriate resources are dynamically loaded and added to the page as necessary, usually in response to user actions.

:computer: **Setup**  

:point_right: editor  

https://code.visualstudio.com/download
:point_right: nodejs  

https://nodejs.org/dist/v16.14.2/node-v16.14.2-x64.msi
https://git-scm.com/download/win

:point_right: angular cli  

```sh
node --version
npm --version

//uninstall angular client globally
npm uninstall -g @angular/cli
//uninstall angular client locally
npm uninstall @angular/cli
//clean the cache
npm cache clean
//install angular client
npm install -g @angular/cli@8.0.1
npm install -g @angular/cli@latest
```
:point_right: create angular project
  
```sh
ng new EFictiShopAngularSPA
```
:point_right: run  
```sh
ng serve
```

:point_right: server-data/employees.json
  
```json
{
  "employees": [
    {
      "id": 1,
      "name": "Ane",
      "salary": 300
    },
    {
      "id": 2,
      "name": "Ben",
      "salary": 400
    }
  ]
}

```


:point_right: setup json server
 
```sh
npm install -g json-server
json-server --watch employees.json
```
