package com.example.javacrm.dal.repositories;

import com.example.javacrm.dal.entities.Post;
import com.example.javacrm.dal.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Integer> {
}
