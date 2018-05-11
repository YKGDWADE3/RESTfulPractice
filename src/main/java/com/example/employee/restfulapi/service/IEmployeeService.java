package com.example.employee.restfulapi.service;

import com.example.employee.restfulapi.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getEmployeeList();

    Employee saveEmployee(Employee employee);

    Employee getEmployee(long id);

    Page<Employee> getEmployeeListByPageAndPageSize(int page, int pageSize);

    List<Employee> getEmployeeListByGender(String gender);

    Employee putEmployee(long id,Employee employee);

    String deleteEmployee(long employeeId);
}
