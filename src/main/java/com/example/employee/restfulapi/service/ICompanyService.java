package com.example.employee.restfulapi.service;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICompanyService {
    List<Company> getCompanyList();

    Company getCompany(long companyId);

    Page<Company> getCompaniesByPageAndPageSize(int page, int pageSize);

    Company saveCompany(Company company);

    Company putCompany(long companyId, Company company);

    String deleteCompany(long companyId);

    List<Employee> getEmployeesByCompanyId(long companyId);

}
