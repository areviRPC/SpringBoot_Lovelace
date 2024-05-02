package com.riwi.vacants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.vacants.entities.Company;

// 5
@Repository
public interface CompanyRespository extends JpaRepository<Company , String> {  

    
}
