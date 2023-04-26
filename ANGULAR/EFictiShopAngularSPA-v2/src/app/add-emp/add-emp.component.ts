import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-add-emp',
  templateUrl: './add-emp.component.html',
  styleUrls: ['./add-emp.component.css']
})
export class AddEmpComponent implements OnInit {
  addForm?: FormGroup;
  constructor(private formBuilder: FormBuilder, private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.addForm = this.formBuilder.group({
      id: [0],
      name: ['Angular'],
      salary: []
    })
  }

  saveEmployee() {
    console.log("Employee details sent to server...");
    console.log(this.addForm.value);
    this.employeeService.createEmployee(this.addForm.value).subscribe((data) => {
      console.log('saved the data', data)
    })
  }
}
