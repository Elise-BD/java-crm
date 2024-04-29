package com.example.javacrm.dal.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Getter
    private Integer id;

    @Column(name = "prix")
    private Float prix;

    // la liste des id documents suffirait
    @ManyToMany
    @JoinTable(name = "Article_documents",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "documents_id"))
    private List<Document> documents = new ArrayList<>();

}
