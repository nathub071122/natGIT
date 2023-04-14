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
        return this.httpClient.get<Employee[]>(this.baseUrl);
    }

    createEmployee(employee: Employee) {
        return this.httpClient.post(this.baseUrl, employee);
    }
    updateEmployee(id: number, employee: any): Observable<Object> {
        return this.httpClient.get<Employee[]>(this.baseUrl);
    }
    deleteEmployee(id: number) {
        return this.httpClient.delete<Employee[]>(this.baseUrl + "/" + id);
    }
}