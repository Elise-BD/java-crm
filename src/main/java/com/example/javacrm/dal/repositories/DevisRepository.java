package com.example.javacrm.dal.repositories;

import com.example.javacrm.dal.entities.Client;
import com.example.javacrm.dal.entities.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisRepository extends JpaRepository<Devis, Integer> {
}
