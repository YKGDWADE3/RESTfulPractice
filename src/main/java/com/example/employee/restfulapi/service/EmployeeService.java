package com.example.employee.restfulapi.service;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.exception.EmployeeAlreadyExistedException;
import com.example.employee.restfulapi.exception.EmployeeNotFoundException;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        if (employeeRepository.findOne(employee.getId()) != null) {
            throw new EmployeeAlreadyExistedException(employee.getId());
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(long id) {
        Employee employee = employeeRepository.findOne(id);
        if (employee == null) {
            throw new EmployeeNotFoundException(id);
        }
        return employee;
    }

    @Override
    public Page<Employee> getEmployeeListByPageAndPageSize(int page, int pageSize) {
        return employeeRepository.findAll(new PageRequest(page, pageSize));
    }

    @Override
    public List<Employee> getEmployeeListByGender(String gender) {
        return employeeRepository.findAllByGender(gender);
    }

    @Override
    public Employee putEmployee(Employee employee) {
        if (employeeRepository.findOne(employee.getId()) == null) {
            throw new EmployeeNotFoundException(employee.getId());
        }
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public String deleteEmployee(long employeeId) {
        if (employeeRepository.findOne(employeeId) == null) {
            throw new EmployeeNotFoundException(employeeId);
        }
        employeeRepository.delete(employeeId);
        return "delete success";
    }


}
