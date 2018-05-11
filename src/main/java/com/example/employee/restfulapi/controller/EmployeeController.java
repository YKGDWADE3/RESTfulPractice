package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import com.example.employee.restfulapi.service.EmployeeService;
import com.example.employee.restfulapi.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    //在此处完成Employee API
    @Autowired
    private IEmployeeService mEmployeeService;

    @GetMapping
    List<Employee> getEmployees() {
        return mEmployeeService.getEmployeeList();
    }

    @GetMapping("id/{employeeId}")
    Employee getEmployee(@PathVariable long employeeId){
        return mEmployeeService.getEmployee(employeeId);
    }

    @GetMapping("page/{pageNumber}/pageSize/{pageSizeNumber}")
    Page<Employee> findByPageAndSize(@PathVariable int pageNumber, @PathVariable int pageSizeNumber) {
        return mEmployeeService.getEmployeeListByPageAndPageSize(pageNumber, pageSizeNumber);
    }

    @GetMapping("gender/{gender}")
    List<Employee> findByGender(@PathVariable String gender){
        return mEmployeeService.getEmployeeListByGender(gender);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Employee createEmployee(@RequestBody Employee input){
        return mEmployeeService.saveEmployee(input);
    }

    @PutMapping("{employeeId}")
    Employee putEmployee(@RequestBody Employee input) {
        return mEmployeeService.putEmployee(input);
    }


}
