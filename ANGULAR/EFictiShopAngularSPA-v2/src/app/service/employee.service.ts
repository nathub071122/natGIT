import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Employee } from "../model/employee.model";

@Injectable({
    providedIn: 'root'
})
export class EmployeeService {
    baseUrl: string = "http://localhost:3000/employees";
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