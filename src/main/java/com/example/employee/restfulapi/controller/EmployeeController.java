package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    //在此处完成Employee API
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("id/{employeeId}")
    Employee getEmployee(@PathVariable long employeeId){
        return employeeRepository.findOne(employeeId);
    }

    @GetMapping("page/{pageNumber}/pageSize/{pageSizeNumber}")
    Page<Employee> findByPageAndSize(@PathVariable int pageNumber, @PathVariable int pageSizeNumber) {
        return employeeRepository.findAll(new PageRequest(pageNumber, pageSizeNumber));
    }

    @GetMapping("gender/{gender}")
    List<Employee> findByGender(@PathVariable String gender){
        return employeeRepository.findAllByGender(gender);
    }

}
