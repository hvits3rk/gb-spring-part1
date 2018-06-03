package com.romantupikov.lesson3.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Ad extends AbstractEntity {

    private String name;
    private String content;
    private String phoneNumber;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Category category;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", company=" + company +
                ", category=" + category +
                '}';
    }
}
