package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {
    //在此处完成Company API
    @Autowired
    ICompanyService mCompanyService;

    @GetMapping
    List<Company> getCompanies() {
        return mCompanyService.getCompanyList();
    }

    @GetMapping("{companyId}")
    Company getCompany(@PathVariable long companyId) {
        return mCompanyService.getCompany(companyId);
    }

    @GetMapping("page/{pageNumber}/pageSize/{pageSizeNumber}")
    Page<Company> getCompaniesByPage(@PathVariable int pageNumber, @PathVariable int pageSizeNumber) {
        return mCompanyService.getCompaniesByPageAndPageSize(pageNumber, pageSizeNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Company saveCompany(@RequestBody Company company) {
        return mCompanyService.saveCompany(company);
    }
}
