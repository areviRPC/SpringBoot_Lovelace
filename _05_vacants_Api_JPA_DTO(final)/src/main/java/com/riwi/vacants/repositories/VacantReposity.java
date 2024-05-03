package com.riwi.vacants.repositories;

import com.riwi.vacants.entities.Vacant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacantReposity extends JpaRepository<Vacant, Long> {
}
