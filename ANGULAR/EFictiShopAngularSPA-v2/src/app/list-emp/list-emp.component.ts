import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../model/employee.model';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-list-emp',
  templateUrl: './list-emp.component.html',
  styleUrls: ['./list-emp.component.css']
})
export class ListEmpComponent implements OnInit {
  employees?: Employee[];
  employeeService: EmployeeService
  constructor(employeeService: EmployeeService, private router: Router) {
    this.employeeService = employeeService;
    // dependency inject the router to navigate dynamically through code

  }

  ngOnInit(): void {
    // Consume the employee Service
    // the special symbol game {{}} [] () ? ! * @ =>
    this.employeeService.getEmployees().subscribe((employeeData) => { this.employees = employeeData });
    // function test(employeeData) {
    //   this.employees = employeeData;
    // }

    // (employeeData) =>   {this.employees = employeeData}
    // employeeData =>   this.employees = employeeData
  }

  //other operations to be implemented create, update, delete
  deleteEmployee(toDeleteEmployee: Employee): void {
    //alert(JSON.stringify(toDeleteEmployee));
    this.employeeService.deleteEmployee(toDeleteEmployee.id).subscribe((deletedEmployee) => {
      //alert(JSON.stringify(deletedEmployee))} );
      // sync the employee with the in-memory array
      this.employees = this.employees.filter(deletedEmployee => deletedEmployee != toDeleteEmployee);
    })
  }
}
