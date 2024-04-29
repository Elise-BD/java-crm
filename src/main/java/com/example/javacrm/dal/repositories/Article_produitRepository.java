package com.example.javacrm.dal.repositories;

import com.example.javacrm.dal.entities.Article_produit;
import com.example.javacrm.dal.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Article_produitRepository extends JpaRepository<Article_produit, Integer> {
}
