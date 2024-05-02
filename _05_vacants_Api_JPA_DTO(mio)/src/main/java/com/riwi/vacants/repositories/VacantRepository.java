package com.riwi.vacants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.vacants.entities.Vacant;

//5
@Repository
public interface VacantRepository extends JpaRepository<Vacant, Long> {
    
}
