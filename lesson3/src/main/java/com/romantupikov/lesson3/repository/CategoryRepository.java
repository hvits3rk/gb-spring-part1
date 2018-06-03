package com.romantupikov.lesson3.repository;

import com.romantupikov.lesson3.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByName(String s);

}
