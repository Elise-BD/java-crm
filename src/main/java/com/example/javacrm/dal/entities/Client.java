package com.example.javacrm.dal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Client extends Prospect{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "reference")
    private String reference = "C-"+id;


    @OneToMany(mappedBy = "idClient", orphanRemoval = true)
    private List<Document> documents = new ArrayList<>();

}
