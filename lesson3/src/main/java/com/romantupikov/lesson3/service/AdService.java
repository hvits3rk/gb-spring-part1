package com.romantupikov.lesson3.service;

import com.romantupikov.lesson3.entity.Ad;
import com.romantupikov.lesson3.repository.AdRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdService {

    private final AdRepository repository;

    public AdService(AdRepository repository) {
        this.repository = repository;
    }

    public List<Ad> findByCategoryId(String categoryId) {
        return repository.findByCategoryId(categoryId);
    }

    public List<Ad> findByCompanyId(String companyId) {
        return repository.findByCompanyId(companyId);
    }

    public void add(Ad ad) {
        repository.save(ad);
    }

    public void update(Ad ad) {
        Optional<Ad> optionalCategory = repository.findById(ad.getId());
        if (optionalCategory.isPresent()) {
            repository.save(ad);
        }
    }

    public void delete(Ad ad) {
        repository.delete(ad);
    }
}
