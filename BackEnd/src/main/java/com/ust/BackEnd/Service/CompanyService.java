package com.ust.BackEnd.Service;

import com.ust.BackEnd.Model.Company;
import com.ust.BackEnd.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company updateCompany(Long id, Company companyDetails) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            company.setName(companyDetails.getName());
            company.setEmail(companyDetails.getEmail());
            company.setPhone(companyDetails.getPhone());
            company.setAddress(companyDetails.getAddress());
            company.setType(companyDetails.getType());
            return companyRepository.save(company);
        } else {
            throw new RuntimeException("Company not found with id " + id);
        }
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
