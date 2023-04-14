import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ListEmpComponent } from "./list-emp/list-emp.component";

// creating the routes in the route configuration file
const routes: Routes = [
    { path: '', component: ListEmpComponent },
    { path: 'employees', component: ListEmpComponent }
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