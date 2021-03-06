package com.example.employee.restfulapi.service;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.exception.ObjectAlreadyExistedException;
import com.example.employee.restfulapi.exception.ObjectNotFoundException;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class CompanyService implements ICompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Company> getCompanyList() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompany(long companyId) {
        Company company = companyRepository.findOne(companyId);
        if (company == null) {
            throw new ObjectNotFoundException(companyId);
        }
        return company;
    }

    @Override
    public Page<Company> getCompaniesByPageAndPageSize(int page, int pageSize) {
        return companyRepository.findAll(new PageRequest(page, pageSize));
    }

    @Override
    public Company saveCompany(Company company) {
        if (companyRepository.findOne(company.getId()) != null) {
            throw new ObjectAlreadyExistedException(company.getId());
        }
        return companyRepository.save(company);
    }

    @Override
    public Company putCompany(long companyId, Company company) {
        if (companyRepository.findOne(companyId) == null) {
            throw new ObjectNotFoundException(companyId);
        }
        company.setId(companyId);
        return companyRepository.saveAndFlush(company);
    }

    @Override
    public String deleteCompany(long companyId) {
        if (companyRepository.findOne(companyId) == null) {
            throw new ObjectNotFoundException(companyId);
        }
        companyRepository.delete(companyId);
        return "delete success";
    }

    @Override
    public List<Employee> getEmployeesByCompanyId(long companyId) {
        Company company = companyRepository.findOne(companyId);
        if (company == null) {
            throw new ObjectNotFoundException(companyId);
        }
        Set<Employee> employees = company.getEmployees();
        return new ArrayList<Employee>(employees);
    }
}
