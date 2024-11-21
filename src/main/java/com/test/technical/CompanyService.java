package com.test.technical;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company saveCompany(Company company) {
        return companyRepository.saveCompany(company);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findByCodeCompany(String codeCompany) {
        return companyRepository.findByCodeCompany(codeCompany);
    }

    public Company updateCompany(Company company) {
        return companyRepository.saveCompany(company);

    }

    public int deleteCompany(int idCompany) {
        return companyRepository.deleteCompany(idCompany);

    }
}
