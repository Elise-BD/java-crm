package com.example.javacrm.dal.repositories;

import com.example.javacrm.dal.entities.Client;
import com.example.javacrm.dal.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer> {
}
