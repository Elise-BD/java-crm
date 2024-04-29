package com.example.javacrm.dal.repositories;

import com.example.javacrm.dal.entities.Article_service;
import com.example.javacrm.dal.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Article_serviceRepository extends JpaRepository<Article_service, Integer> {
}
