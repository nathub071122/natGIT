import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Employee } from "../model/employee.model";

@Injectable({
    providedIn: 'root'
})
export class EmployeeService {
    // JSON SERVER REST AIP
    // baseUrl: string = "http://localhost:3000/employees";
    // SPRING BOOT REST API
    baseUrl: string = "http://localhost:8080/api/v1/employees";

    // Access to XMLHttpRequest at 'http://localhost:8080/api/v1/employees' from origin 'http://localhost:4200'
    //  has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.
    
    constructor(private httpClient: HttpClient) {
    }
    getEmployees() {
        //get
        return this.httpClient.get<Employee[]>(this.baseUrl);
    }

    createEmployee(employee: Employee) {
        //post
        return this.httpClient.post(this.baseUrl, employee);
    }
    updateEmployee(id: number, employee: any): Observable<Object> {
        //put
        return this.httpClient.get<Employee[]>(this.baseUrl);
    }
    deleteEmployee(id: number) {
        // //alert(id);
        //alert(this.baseUrl+"/"+id);
        //delete
        return this.httpClient.delete<Employee>(this.baseUrl + "/" + id);
    }
}