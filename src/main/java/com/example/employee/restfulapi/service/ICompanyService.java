package com.example.employee.restfulapi.service;

import com.example.employee.restfulapi.entity.Company;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICompanyService {
    List<Company> getCompanyList();

    Company getCompany(long companyId);

    Page<Company> getCompaniesByPageAndPageSize(int page, int pageSize);

    Company saveCompany(Company company);

    Company putCompany(long companyId, Company company);

}
