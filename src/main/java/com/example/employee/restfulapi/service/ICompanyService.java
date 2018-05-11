package com.example.employee.restfulapi.service;

import com.example.employee.restfulapi.entity.Company;

import java.util.List;

public interface ICompanyService {
    List<Company> getCompanyList();

    Company getCompany(long companyId);

}
