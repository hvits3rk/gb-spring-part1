package com.romantupikov.lesson3;

import com.romantupikov.lesson3.config.AppConfig;
import com.romantupikov.lesson3.config.PersistenceConfig;
import com.romantupikov.lesson3.entity.Ad;
import com.romantupikov.lesson3.entity.Category;
import com.romantupikov.lesson3.entity.Company;
import com.romantupikov.lesson3.service.AdService;
import com.romantupikov.lesson3.service.CategoryService;
import com.romantupikov.lesson3.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class, PersistenceConfig.class);

        CompanyService companyService = context.getBean(CompanyService.class);
        CategoryService categoryService = context.getBean(CategoryService.class);
        AdService adService = context.getBean(AdService.class);

        Company company = new Company();
        company.setName("Arcanum");
        company.setAddress("Some Arcanum address");
        company.setDescription("Arcanum Company");
        companyService.add(company);

        Category category = new Category();
        category.setName("Employee");
        categoryService.add(category);

//        Company company = companyService.findByName("Arcanum");
//        Category category = categoryService.findByName("Employee");

        Ad ad = new Ad();
        ad.setName("Python Programmer");
        ad.setContent("Looking for Python programmer");
        ad.setPhoneNumber("8 (800) 345 1234");
        ad.setCategory(category);
        ad.setCompany(company);

        company.getAdList().add(ad);

        category.getAdList().add(ad);

        adService.add(ad);

        companyService.update(company);
        categoryService.update(category);

        for (Ad eachAd : adService.findByCategoryId(category.getId())) {
            log.info("{}", eachAd);
        }

        context.close();
    }
}
