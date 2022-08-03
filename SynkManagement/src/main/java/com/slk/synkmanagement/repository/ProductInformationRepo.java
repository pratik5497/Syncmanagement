package com.slk.synkmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slk.synkmanagement.model.ProductInformation;

public interface ProductInformationRepo extends JpaRepository<ProductInformation, Integer> {

}
