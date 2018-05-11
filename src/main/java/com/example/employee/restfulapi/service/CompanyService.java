package com.example.employee.restfulapi.service;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.exception.ObjectNotFoundException;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

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
}
