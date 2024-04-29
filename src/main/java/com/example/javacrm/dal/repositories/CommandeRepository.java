package com.example.javacrm.dal.repositories;

import com.example.javacrm.dal.entities.Client;
import com.example.javacrm.dal.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}
