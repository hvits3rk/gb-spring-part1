package com.romantupikov.lesson3.repository;

import com.romantupikov.lesson3.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, String> {

    List<Ad> findByCategoryId(String categoryId);

    List<Ad> findByCompanyId(String companyId);
}
