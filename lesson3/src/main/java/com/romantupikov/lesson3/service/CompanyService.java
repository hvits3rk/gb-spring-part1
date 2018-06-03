package com.romantupikov.lesson3.service;

import com.romantupikov.lesson3.entity.Company;
import com.romantupikov.lesson3.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public Company findById(String companyId) {
        return repository.findById(companyId).orElse(null);
    }

    public Company findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public void add(Company company) {
        repository.save(company);
    }

    public void update(Company company) {
        Optional<Company> optionalCategory = repository.findById(company.getId());
        if (optionalCategory.isPresent()) {
            repository.save(company);
        }
    }

    public void delete(Company company) {
        repository.delete(company);
    }
}
