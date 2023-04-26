import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ListEmpComponent } from "./list-emp/list-emp.component";
import { LoginComponent } from "./login/login.component";
import { AuthGuardService } from "./service/auth-guard.service";
import { AddEmpComponent } from "./add-emp/add-emp.component";

// creating the routes in the route configuration file
const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },
    { path: 'employees', component: ListEmpComponent, canActivate:[AuthGuardService] },
    { path: 'add', component: AddEmpComponent, canActivate:[AuthGuardService] }
]

@NgModule({
    // The Router moudle to load the routes
    imports: [
        // Import the angular router module to be used inside this module.
        RouterModule.forRoot(routes)
    ],
    exports: [RouterModule]
})
export class AppRoutingModule {

}