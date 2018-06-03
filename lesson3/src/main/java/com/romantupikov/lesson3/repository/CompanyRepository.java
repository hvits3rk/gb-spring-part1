package com.romantupikov.lesson3.repository;

import com.romantupikov.lesson3.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, String> {

    Optional<Company> findByName(String name);

}
